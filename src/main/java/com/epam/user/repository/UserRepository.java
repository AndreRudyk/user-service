package com.epam.user.repository;

import com.epam.user.exception.UserNotFoundException;
import com.epam.user.model.User;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Repository
public class UserRepository {
    private  final List<User> users = new ArrayList<>();

    public Optional<User> findById(Long id){
        return users.stream()
                .filter(user->user.getId().equals(id))
                .findFirst();
    }

    public Optional<User> findByEmail(String email){
        return users.stream()
                .filter(user->user.getEmail().equals(email))
                .findFirst();
    }

    public User create(User user){
        user.setId(users.size() + 1L);
        users.add(user);
        return user;
    }
    public void deleteById(Long id){
        users.removeIf(user->user.getId().equals(id));
    }

    public User update(User user){
        boolean isRemoved = users.removeIf(u->u.getId().equals(user.getId()));
        if(!isRemoved){
            throw new UserNotFoundException(
                    String.format("User with id %s is not found", user.getId())
            );
        }
        users.add(user);
        return user;
    }


}
