package com.example.dao;

import com.example.pojo.User;
import com.example.util.JDBCTools;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * @author code clone detection group
 * @version 1.0
 * @email martinchan709@gmail.com
 */
public class UserDao {

//    public static void main(String[] args) {
//        UserDao userDao = new UserDao();
//
//        List<User> all = userDao.findAll();
//        System.out.println(all.toString());
//
//        userDao.add(12,"小明");
//    }

    //查找全部
    public List<User> findAll() {
        ArrayList<User> userArrayList = new ArrayList<>();
        Connection connection =null;
        PreparedStatement preparedStatement =null;
        ResultSet resultSet = null;

        try {
            connection = JDBCTools.getConnection();
            String sql = "select * from test1";
            preparedStatement = connection.prepareStatement(sql);
            resultSet = preparedStatement.executeQuery();
            while (resultSet.next()){
                Integer id = resultSet.getInt(1);
                String name = resultSet.getString(2);
                User user = new User(id, name);
                userArrayList.add(user);
            }
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            JDBCTools.release(connection,preparedStatement,resultSet);
        }

        return userArrayList;
    }

    //添加操作
    public void add(Integer id,String name){
        Connection connection=null;
        PreparedStatement preparedStatement=null;
        try {
            connection= JDBCTools.getConnection();
            String sql="insert into user01(id,name) values (?,?)";
            preparedStatement=connection.prepareStatement(sql);
            //这里注意第一个参数对应sql语句问号的序号，
            preparedStatement.setInt(1,id);//就是把id替代sql的第一个问号，id由前端传过来
            preparedStatement.setString(2,name);
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            JDBCTools.release(connection,preparedStatement,null);
        }
    }

    //删除操作
    public void deleteById(Integer id){
        Connection connection=null;
        PreparedStatement preparedStatement=null;
        try {
            connection= JDBCTools.getConnection();
            String sql="delete from user01 where id=?";
            preparedStatement=connection.prepareStatement(sql);
            preparedStatement.setInt(1,id);
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            JDBCTools.release(connection,preparedStatement,null);
        }
    }

    //根据id查询
    public User findById(Integer id){
        Connection connection=null;
        PreparedStatement preparedStatement=null;
        ResultSet resultSet=null;
        User user=null;
        try {
            connection= JDBCTools.getConnection();
            String sql="select * from user01 where id=?";
            preparedStatement=connection.prepareStatement(sql);
            preparedStatement.setInt(1,id);
            resultSet = preparedStatement.executeQuery();
            while (resultSet.next()){
                Integer id2=resultSet.getInt(1);
                String name=resultSet.getString(2);
                user= new User(id2, name);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            JDBCTools.release(connection,preparedStatement,resultSet);
        }
        return user;
    }

    //更新操作
    public void update(Integer id,String name){
        Connection connection=null;
        PreparedStatement preparedStatement=null;
        try {
            connection= JDBCTools.getConnection();
            String sql="update user01 set name=? where id=?";
            preparedStatement=connection.prepareStatement(sql);
            preparedStatement.setString(1,name);
            preparedStatement.setInt(2,id);
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            JDBCTools.release(connection,preparedStatement,null);
        }
    }

}
