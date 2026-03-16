package com.hexagonal.ArquiteturaHexagonal.externals.db.relationalAdapter;

import com.hexagonal.ArquiteturaHexagonal.core.shared.exception.UserNotFoundException;
import com.hexagonal.ArquiteturaHexagonal.core.user.User;
import com.hexagonal.ArquiteturaHexagonal.core.user.repository.UserRepository;
import com.hexagonal.ArquiteturaHexagonal.externals.db.repository.SpringDataUserRepository;
import com.hexagonal.ArquiteturaHexagonal.externals.entity.UserEntity;

import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public class UserDbAdapter implements UserRepository {

    private final SpringDataUserRepository jpaRepo;

    public UserDbAdapter(SpringDataUserRepository jpaRepo){
        this.jpaRepo = jpaRepo;
    }

    @Override
    public User salvar(User user) {
        UserEntity entity = new UserEntity();
        entity.setNome(user.getNome());
        entity.setEmail(user.getEmail());
        entity.setCpf(user.getCpf());
        entity.setSenha(user.getSenha());

         entity = jpaRepo.save(entity);
         return entity.toDomain();
    }

    @Override
    public Optional<User> buscar(Long id) {
        return jpaRepo.findById(id).map(UserEntity::toDomain);
    }

    @Override
    public void deletar(Long id) {
        Optional<UserEntity> userDeletado =  jpaRepo.findById(id);
        userDeletado.ifPresent(user -> jpaRepo.deleteById(id));
    }

    @Override
    public User alterarUsuario(Long id, User novoUser) {
       return jpaRepo.findById(id).map(
                userExist -> {
                    userExist.setNome(novoUser.getNome());
                    userExist.setEmail(novoUser.getEmail());

                    UserEntity entitySave = jpaRepo.save(userExist);
                    return entitySave.toDomain();
                }
        ).orElseThrow(() -> new UserNotFoundException("Usuário com ID " + id + " não encontrado"));

    }

}
