/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package diplom;


import static diplom.NewJFrame.kriter;
import static diplom.NewJFrame.messNotFound;
import static diplom.NewJFrame.sortType;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFrame;

/**
 *
 * @author Artemi
 */
public class Diplom extends JFrame{
    private static Connection connection;
    static int idt; //Главный герой романа
    static Statement st;
    public static boolean cheky = false;
    static Integer[] idRes;
    static String[] al;
     
    static{
        try {
            Class.forName("com.mysql.jdbc.Driver");
            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/mydb", "root", "admin");
            st = connection.createStatement();
       } catch (ClassNotFoundException e) {
        } catch (SQLException ex) {
            Logger.getLogger(Diplom.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    /**
     * @param args the command line arguments
     * @throws java.sql.SQLException
     */
    public static void main(String[] args) throws SQLException {
        
        new NewJFrame().setVisible(true);
        // TODO code application logic here
    }

    public static void idtCheck() throws SQLException {
         ResultSet rs = st.executeQuery("select idtours from mydb.tours where `real` = 1");
         cheky = false;
         
         while (rs.next())
         {
             int a = Integer.parseInt(rs.getString(1));
           if (a==idt)
           {
               cheky = true;
               break;
               
           }
         }
           if(!cheky) messNotFound();
           rs.close();//To change body of generated methods, choose Tools | Templates.
    } 
    static String getTourId(int idt) throws SQLException
        {
            ResultSet rs = st.executeQuery("select idtours from mydb.tours where idtours = " + String.valueOf(idt));
            String s = "";
            if (rs.next()) s = rs.getString(1);
            rs.close();
            return s;
        }

    static String getTourPrice(int idt) throws SQLException
        {
            ResultSet rs = st.executeQuery("select price from mydb.tours where idtours = " + String.valueOf(idt));
            String s = "";
            if (rs.next()) s = rs.getString(1);
            rs.close();
            return s;
        }

    static String getTourDate(int idt) throws SQLException
        {
            ResultSet rs = st.executeQuery("select date_in from mydb.tours where idtours = " + String.valueOf(idt));
            String s = "";
            if (rs.next()) s = rs.getString(1);
            rs.close();
            return s;
        }

    static String getTourLong(int idt) throws SQLException
        {
            ResultSet rs = st.executeQuery("select how_long from mydb.tours where idtours = " + String.valueOf(idt));
            String s = "";
            if (rs.next()) s = rs.getString(1);
            rs.close();
            return s;
        }

    static String getTourFood(int idt) throws SQLException
        {
            ResultSet rs = st.executeQuery("select food_idfood from mydb.tours where idtours = " + String.valueOf(idt));
            String t = "";
            String s = "";
            if (rs.next()) t = rs.getString(1);
            rs = st.executeQuery("select food_cat from mydb.food where idfood = " +  t);
            if (rs.next()) s = rs.getString(1);
            rs.close();
            return s;
        }

    static String getTourHotelName(int idt) throws SQLException
        {
            ResultSet rs = st.executeQuery("select hotelsname from mydb.tours where idtours = " + String.valueOf(idt));
            String s = "";
            if (rs.next()) s = rs.getString(1);
            rs.close();
            return s;
        }

    static String getTourPeopCount(int idt) throws SQLException
        {
            ResultSet rs = st.executeQuery("select peoplecount_idpeoplecount from mydb.tours where idtours = " + String.valueOf(idt));
            String t = "";
            String s = "";
            if (rs.next()) t = rs.getString(1);
            rs = st.executeQuery("select peoplecountcol from mydb.peoplecount where idpeoplecount = " +  t);
            if (rs.next()) s = rs.getString(1);
            rs.close();
            return s;
        }

    static String getTourApart(int idt) throws SQLException
        {
            ResultSet rs = st.executeQuery("select apartments from mydb.tours where idtours = " + String.valueOf(idt));
            String s = "";
            if (rs.next()) s = rs.getString(1);
            rs.close();
            return s;
        }

    static String getTourHotelCat(int idt) throws SQLException
        {
            ResultSet rs = st.executeQuery("select hotelCategory from mydb.tours where idtours = " + String.valueOf(idt));
            String s = "";
            if (rs.next()) s = rs.getString(1);
            rs.close();
            return s;
        }

    static String getTourCountry(int idt) throws SQLException
        {
            ResultSet rs = st.executeQuery("select countries_idcountries from mydb.tours where idtours = " + String.valueOf(idt));
            String t = "";
            String s = "";
            if (rs.next()) t = rs.getString(1);
            rs = st.executeQuery("select country_name from mydb.countries where idcountries = " +  t);
            if (rs.next()) s = rs.getString(1);
            rs.close();
            return s;
        }

    static String getTourCity(int idt) throws SQLException
        {
            ResultSet rs = st.executeQuery("select city_idcity from mydb.tours where idtours = " + String.valueOf(idt));
            String t = "";
            String s = "";
            if (rs.next()) t = rs.getString(1);
            rs = st.executeQuery("select cityname from mydb.city where idcity = " +  t);
            if (rs.next()) s = rs.getString(1);
            rs.close();
            return s;
        }

    static String getTourOper(int idt) throws SQLException
        {
            ResultSet rs = st.executeQuery("select operator_idoperator from mydb.tours where idtours = " + String.valueOf(idt));
            String t = "";
            String s = "";
            if (rs.next()) t = rs.getString(1);
            rs = st.executeQuery("select operator_name from mydb.operator where idoperator = " +  t);
            if (rs.next()) s = rs.getString(1);
            rs.close();
            return s;
        }
    static String getFullString(int i) throws SQLException
    {
        String s = getTourId(i) + " " + getTourCountry(i) + " " + getTourCity(i) + " " + getTourHotelName(i) + getTourHotelCat(i)+ "* " + getTourApart(i) + " " + getTourDate(i) + " " + getTourLong(i)+ "d " + getTourFood(i) + " " + getTourPrice(i)+"r " + getTourOper(i);
    return s;
    }

    static String[] letsCreateList() {
        
        String[] list = null;
        ArrayList<Integer>  idList = new ArrayList<>();
        try{
        String s = queryForm(kriter);
            try (ResultSet rs = st.executeQuery(s)) {
                while (rs.next()) idList.add(Integer.parseInt(rs.getString(1)));
            }
        list = DrawAndSort(idList);
        
        return list;
        }
        catch (SQLException e)
        {
            Logger.getLogger(Diplom.class.getName()).log(Level.SEVERE, null, e);
            return list;
        }
        
        
    }
    static double abcRate(String country) throws SQLException
    {
        double a = 0;
        ResultSet rs = st.executeQuery("select ABCXYZrate from mydb.countries where country_name = " + "\"" + country + "\"");
            if (rs.next()) a = Double.parseDouble(rs.getString(1));
        
        return a;
    }


    private static String[] DrawAndSort(ArrayList<Integer> idList) throws SQLException{
        String[] list;
        ArrayList<Double> koffList = new ArrayList<>();
        ArrayList<String> listInfo = new ArrayList<>();
        for (int x : idList)
        {
            double koff;
            double count;
            int kritCount = 0;
            if(getTourCountry(x).equals(getTourCountry(idt))) kritCount++;
            if(getTourCity(x).equals(getTourCity(idt))) kritCount++;
            if(getTourHotelName(x).equals(getTourHotelName(idt))) kritCount++;
            if(getTourHotelCat(x).equals(getTourHotelCat(idt))) kritCount++;
            if(getTourLong(x).equals(getTourLong(idt))) kritCount++;
            if(getTourFood(x).equals(getTourFood(idt))) kritCount++;
            if(getTourOper(x).equals(getTourOper(idt))) kritCount++;
            if(Integer.parseInt(getTourPrice(x))>=Integer.parseInt(getTourPrice(idt)) && Integer.parseInt(getTourPrice(x))<=Integer.parseInt(getTourPrice(idt))+10000 ) kritCount=kritCount+2;
            if(Integer.parseInt(getTourPrice(x))<=Integer.parseInt(getTourPrice(idt)) && Integer.parseInt(getTourPrice(x))>=Integer.parseInt(getTourPrice(idt))-10000 ) kritCount=kritCount+2;
            if (kritCount==0) count = 0.5; else count = (double) kritCount;
            koff = (1/count);
            koffList.add(koff);
            }
        if (sortType.equals("ABC.RateOfCountry"))
        {
            for (int i = 0; i < idList.size(); i++)
            {   
                double a = koffList.get(i) * abcRate(getTourCountry(idList.get(i)));
                koffList.set(i, a);
            }
        }
        Double[] koffListForSort = koffList.toArray(new Double[koffList.size()]);
        Integer[] idListForSort = idList.toArray(new Integer[idList.size()]);
        if (koffListForSort.length == idListForSort.length)
        timeForBubble(koffListForSort, idListForSort);
        for (int x : idListForSort)
        {
            listInfo.add(getFullString(x));
        }
        list = listInfo.toArray(new String[listInfo.size()]);
        idRes = idListForSort;
        return list;
        }


    private static String queryForm(String kriter) throws SQLException {
            String t = "";
            String b = "";
            ResultSet rs = st.executeQuery("select idpeoplecount from mydb.peoplecount where peoplecountcol = \"" + getTourPeopCount(idt)+"\"");
            if (rs.next()) t = rs.getString(1);
            rs.close();
            
            switch (kriter) {
                case "Страна" :
                    ResultSet rs1 = st.executeQuery("select idcountries from mydb.countries where country_name = \"" + getTourCountry(idt) + "\"");
                    if (rs1.next()) b = "countries_idcountries <> " + rs1.getString(1);
                    rs1.close();
                    break;
                case "Город" :
                    ResultSet rs2 = st.executeQuery("select idcity from mydb.city where cityname = " + "\"" + getTourCity(idt)+"\"");
                    if (rs2.next()) b = "city_idcity <> " + rs2.getString(1);
                    rs2.close();
                    break;
                case "Отель" :
                    b = "hotelsname <> " + "\"" + getTourHotelName(idt) + "\"";
                    break;
                case "Туроператор" :
                    ResultSet rs3 = st.executeQuery("select idoperator from mydb.operator where operator_name = " + "\""+ getTourOper(idt) + "\"");
                    if (rs3.next()) b = "operator_idoperator <> " + rs3.getString(1);
                    rs3.close();
                    break;
            }
            String s = "select idtours from mydb.tours where idtours <> " + String.valueOf(idt) + " and `real` = 0 and peoplecount_idpeoplecount = " + t + " and " + b;
            return s;//To change body of generated methods, choose Tools | Templates.
    }

    
    private static void timeForBubble(Double[] koffListForSort, Integer[] idListForSort) {
        for (int i = 0; i < koffListForSort.length; i++){
        for ( int j = koffListForSort.length-1; j>i;j--){
             if (koffListForSort[j]<koffListForSort[j-1])
             {
                 double tempDouble = koffListForSort[j];
                 int tempInt = idListForSort[j];
                 koffListForSort[j] = koffListForSort[j-1]; 
                   idListForSort[j] = idListForSort[j-1];
                   koffListForSort[j-1] = tempDouble;
                   idListForSort[j-1] = tempInt;
             }
        }
        }
    
    }

    
}
