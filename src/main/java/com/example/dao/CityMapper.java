package com.example.dao;

import com.example.domain.City;
import org.apache.ibatis.annotations.Mapper;

/**
 * ${DESCRIPTION}
 *
 * @author sxp
 * @create 2016/12/31.
 *
 * 方式一 使用xml
 *      ① 配置 application.properties 指定xml路径 与别名
                    mybatis.mapperLocations=classpath:mapper/*.xml
                    mybatis.typeAliasesPackage=com.example.domain
 *      ② 接口用 @Mapper注解接口
 *      ③ 对应xml 编写
 *
 * 方式二
 *     直接使用 全注解
 *        见 UserMapper
 *
 *
 */
@Mapper
public interface CityMapper {

    public City selectCityById(int id);

}
