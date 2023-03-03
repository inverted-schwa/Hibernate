package mydemo.training.firstHiber;

import mydemo.training.firstHiber.service.StudentService;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        StudentService sserv = new StudentService();
        //sserv.insertData();
       // sserv.deleteData();
        //sserv.updateData();
        //sserv.view();
        //sserv.viewByName();
        //sserv.sortData();
        sserv.retrieveByScore();
    }
    
}
