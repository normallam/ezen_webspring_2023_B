package day04;

import org.springframework.stereotype.Component;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

@Component // Spring MVC는 아니지만 . 해당 클래스를 빈 등록
            // 해당 클래스를 스프링 컨테이너에 빈 등록
public class TodoDao {
    private Connection conn;
    private PreparedStatement ps;
    private ResultSet rs;

    // 비어있는 생성자에 DB연동
    public TodoDao(){
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/springweb", "root", "1234");
            System.out.println("연동성공");
        } catch (Exception e) {
            System.out.println("연동실패" + e);
        }
    }



    // 1. [C]
    public boolean doPost(TodoDto todoDto){
        // SQL
        String sql = "insert into todo( tcontent , tstate ) values( ? , ? )";
        try {
            ps = conn.prepareStatement(sql);

            ps.setString(1, todoDto.getTcontent());
            ps.setBoolean(2,todoDto.isTstate());
            int count = ps.executeUpdate();
            if(count==1){
                return true;
            }
        }catch (Exception e){
            System.out.println("e = " + e);}
        return false;
    }
    // 2. [R]
    public List<TodoDto> doGet(){
        // SQL
        List<TodoDto> list = new ArrayList<>();
        String sql = "select * from todo";

        try {

            ps = conn.prepareStatement(sql);

            rs = ps.executeQuery();

            while (rs.next()){
                list.add( TodoDto.builder()
                        .tno(rs.getInt("tno"))
                        .tcontent(rs.getString("tcontent"))
                        .tstate(rs.getBoolean("tstate"))
                        .build());
            }

        }catch ( Exception e ) {
            System.out.println("e = " + e);
        }

        return list;
    }
    // 3. [U]
    public boolean doPut(TodoDto todoDto){
        // SQL
        String sql = "update todo set tstate = ? where tno = ?";
        try {
            ps = conn.prepareStatement(sql);
            ps.setBoolean(1,todoDto.isTstate());
            ps.setInt(2,todoDto.getTno());
            int count = ps.executeUpdate();
            if(count == 1)return true;
        }catch (Exception e){
            System.out.println("e = " + e);}
        return false;
    }
    // 4. [D]
    public boolean doDelete(int tno){
        // SQL
        String sql = "delete from todo where tno = ?";
        try {
            ps = conn.prepareStatement(sql);
            ps.setInt(1,tno);
            int count = ps.executeUpdate(); if(count == 1) return true;
        }catch (Exception e){
            System.out.println("e = " + e);}
        return false;
    }


}
