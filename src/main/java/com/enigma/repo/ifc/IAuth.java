package com.enigma.repo.ifc;

import com.enigma.model.UserCredential;

public interface IAuth {
    void create(UserCredential userCredential);
    UserCredential findOne(String id);
}
