package com.enigma.repo.ifc;

import com.enigma.model.Major;

public interface IMajor {
    void create(Major major);
    Major findOne(long id);
}
