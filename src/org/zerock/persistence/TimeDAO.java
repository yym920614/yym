package org.zerock.persistence;

import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Connection;

public class TimeDAO {

   public String getSysdate() throws Exception {

      Connection con = null;
      PreparedStatement pstmt = null;
      ResultSet rs = null;

      try {
         Class.forName("oracle.jdbc.driver.OracleDriver");
         con = DriverManager.getConnection("jdbc:oracle:thin:@192.168.0.51:1521:XE", 
               "bit88", 
               "bit88");

         pstmt = con.prepareStatement("select sysdate");

         rs = pstmt.executeQuery();

         while (rs.next()) {
            return rs.getString(1);
         }

      } catch (Exception e) {
         e.printStackTrace();
      } finally {
         if (rs != null) {try {rs.close();} catch (Exception e) {}};
         if (pstmt != null) {try {pstmt.close();} catch (Exception e) {}};
         if (con != null) {try {con.close();} catch (Exception e) {}};
               }
      return null;
   }
}