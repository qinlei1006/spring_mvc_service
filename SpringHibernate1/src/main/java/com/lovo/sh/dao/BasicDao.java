package com.lovo.sh.dao;

import com.lovo.sh.entity.UserEntity;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate5.LocalSessionFactoryBean;
import org.springframework.stereotype.Repository;


import java.util.List;


@Repository
//@Transactional(rollbackFor = {Exception.class},isolation = Isolation.DEFAULT)
public class BasicDao<T> {
    Class<T> cl=null;
    public BasicDao(){
        cl= ReflectUtils.getClassGenricType(this.getClass());
    }

    @Autowired
    private LocalSessionFactoryBean localSessionFactoryBean;

    /**
     * 获得session
     * @return
     */
    public Session getOpenSession(){
        return localSessionFactoryBean.getObject().openSession();
    }

    /** CurrentSession 是被spring管理的session，
     * 这个session 需要spring事务支持，关闭session由spring来完成
     * @return
     */
    public Session  getCurrentSession(){
        return localSessionFactoryBean.getObject().getCurrentSession();
    }


    /**
     * 保存
     * @param t
     */
    public void saveObject(T t){
        this.getCurrentSession().save(t);
    }

    /**
     * 删除
     * @param t
     */
    public void delete(T t){
        this.getCurrentSession().delete(t);
    }

    /**
     * 按照ID删除
     * @param id
     */
    public void deleteId(String id){
        Object object = this.getCurrentSession().get(cl,id);
        this.getCurrentSession().delete(object);
    }

    /**
     * 修改
     * @param t
     */
    public void update(T t){
        this.getCurrentSession().update(t);
    }

    /**
     * 查询所有
     * @return
     */
    public List<T> findAll(){
        String hql = "from "+cl.getSimpleName();
        return this.getCurrentSession()
                .createQuery(hql)
                .list();
    }

    public Object findObj(String name){
        String hql = "from " + cl.getSimpleName()  +" where u_name = ?";

      return   this.getCurrentSession()
              .createQuery(hql)
              .setParameter(0,name)
              .uniqueResult();
    }

    public List<T> getListArray(String hql,Object[] objects){
        Query query =  this.getCurrentSession().createQuery(hql);
        for (int i=0;i<objects.length;i++){
            query.setParameter(i,objects[i]);
        }
       return query.list();
    }

    public void test(){
//        得到session
        Session s = this.getOpenSession();
//        得到事务
        Transaction tx = s.getTransaction();
//        开启事务
        tx.begin();
        UserEntity userEntity =
                s.get(UserEntity.class,"4028098171076ad60171076adaa30000");
        System.out.println(userEntity.getUserName());

        try {
            Thread.sleep(1000*5);
            s.close(); //清空缓存
            s.flush(); // 刷新缓存
            tx.commit(); //事务提交
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        UserEntity userEntity2 =
                s.get(UserEntity.class,"4028098171076ad60171076adaa30000");
        System.out.println(userEntity2.getUserName());
        UserEntity userEntity3 =
                s.get(UserEntity.class,"4028098171076ad60171076adaa30000");
        System.out.println(userEntity3.getUserName());

        s.close();
    }

}
