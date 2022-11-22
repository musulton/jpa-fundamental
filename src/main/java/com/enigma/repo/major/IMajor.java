package com.enigma.repo.major;

import com.enigma.model.Major;

public interface IMajor {
    void create(Major major);
    Major findOne(long id);
}
