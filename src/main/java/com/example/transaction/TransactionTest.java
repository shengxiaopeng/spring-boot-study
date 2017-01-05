package com.example.transaction;

import com.example.dao.CityMapper;
import com.example.dao.UserMapper;
import com.example.domain.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * ${DESCRIPTION}
 *
 * @author sxp
 * @create 2017/1/5.
 */

@Service
public class TransactionTest {

    @Autowired
    CityMapper cityMapper;

    @Autowired
    UserMapper userMapper;

    @Transactional(rollbackFor = IllegalArgumentException.class)
    public  void  saveWithRollBack(){

        User user=new User("test1","type1");
        userMapper.addUser(user);

        throw new IllegalArgumentException("伙计，回滚了");

    }

    @Transactional(noRollbackFor  = IllegalArgumentException.class)
    public  void  saveWithoutRollBack(){

        User user=new User("test1","type1");
        userMapper.addUser(user);

        throw new IllegalArgumentException("伙计，没有回滚了");

    }


}
