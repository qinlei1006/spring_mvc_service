package com.lovo.jpa.dao;

import com.lovo.jpa.dto.UserDto;
import com.lovo.jpa.entity.UserEntity;
import org.hibernate.query.NativeQuery;
import org.hibernate.query.internal.NativeQueryImpl;
import org.hibernate.transform.Transformers;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.servlet.HandlerInterceptor;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import java.util.List;
import java.util.Map;

@Transactional
@Repository(value = "basicDao")
public class BasicDao {

    @Autowired
    private LocalContainerEntityManagerFactoryBean managerFactoryBean;

    public EntityManager getEntityManager(){
        EntityManagerFactory managerFactory =
                managerFactoryBean.getNativeEntityManagerFactory();

        return  managerFactory.createEntityManager();
    }

    public List<UserEntity> findListHQL(){
        String hql = "from UserEntity where userName like ?1";
     return    this.getEntityManager().createQuery(hql)
                .setParameter(1,"%飞%")
                 .getResultList();
    }

    public UserEntity findUserEntity(){
        String hql = "from UserEntity where userId = ?1 ";
       return (UserEntity) this.getEntityManager().createQuery(hql)
                .setParameter(1,"20")
                .getSingleResult();
    }

    public UserEntity findUser(){
        String hql = "from UserEntity where userId =:id";
      return (UserEntity)this.getEntityManager()
                .createQuery(hql)
                .setParameter("id","22")
                .getSingleResult();

    }

    public List<UserEntity> getListSql(){
        String sql = "select * from sys_user where u_age = ?";
        NativeQuery query = (NativeQuery) this.getEntityManager()
                .createNativeQuery(sql);
        query.addEntity(UserEntity.class);
        query.setParameter(1,18);
        return query.getResultList();

    }

    public List<UserDto> findDto(){
        String hql = "select new com.lovo.jpa.dto.UserDto(userName,age) from UserEntity";
      return this.getEntityManager()
                .createQuery(hql)
                .getResultList();
    }

    public List<Map> findMap(){
        String hql = "select new map(addDate,password,userName) from UserEntity";
         return   this.getEntityManager().createQuery(hql).getResultList();
    }


    public List<UserEntity> getSql(){
        String sql = "select * from sys_user where u_name like ?1";
      NativeQuery query = (NativeQuery) this.getEntityManager().createNativeQuery(sql);
      query.addEntity(UserEntity.class);
      query.setParameter(1,"%李%");
      return query.getResultList();

    }

    public List<Map> getMapSql(){
        String sql = "select u.* from sys_user u where u_age > ?1";
       return this.getEntityManager().createNativeQuery(sql)
              .setParameter(1,"16")
                .unwrap(NativeQueryImpl.class)
                .setResultTransformer(Transformers.ALIAS_TO_ENTITY_MAP)
                .list();
    }




}
