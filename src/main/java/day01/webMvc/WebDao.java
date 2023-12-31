package day01.webMvc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class WebDao {

    //[ import java.sql ]
    public Connection conn; // DB 연동 객체
    public PreparedStatement ps; //연동된 DB 조작 객체
    public ResultSet rs; // SQL 조작 결과를 가져오는 객체



    public WebDao() {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/springweb", "root", "1234");
            System.out.println("연동성공");
        } catch (Exception e) {
            System.out.println("연동실패" + e);
        }
    }

    public List<WebDto> doGet(){
        List<WebDto> list = new ArrayList<>();
        try {

            String sql = "select * from todo";
            ps = conn.prepareStatement(sql);
            rs = ps.executeQuery();
            while (rs.next()){
                WebDto webDto =new WebDto(
                        rs.getInt(1),
                        rs.getString(2),
                        LocalDate.parse(rs.getString(3)),
                        rs.getBoolean(4));
                list.add(webDto);
            }
        }catch (Exception e){
            System.out.println(e);}


        return list;
    }

    public boolean doPost(WebDto dto){
        //todo 테이블

        try{
        String sql = "insert into todo(title,dueDate,finished)values(?,?,?)";
        ps = conn.prepareStatement(sql);
        ps.setString(1,dto.getTitle());
        ps.setString(2, dto.getDuedate().toString());
        ps.setBoolean(3, dto.isFinished());
        int count = ps.executeUpdate();
        if(count == 1)return true;

        }catch (Exception e) {System.out.println(e);}

        return false;
    }
}
