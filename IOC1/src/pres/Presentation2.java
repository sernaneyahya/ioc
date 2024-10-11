package pres;

import dao.IDao;
import metier.IMetier;
import metier.MetierImpl;

import java.io.File;
import java.io.FileNotFoundException;
import java.lang.reflect.Method;
import java.util.Scanner;

public class Presentation2 {
    public static void main(String[] args) throws Exception {
        Scanner scanner = new Scanner(new File("config.txt"));
        String daoClassName = scanner.nextLine();
        Class daoClass = Class.forName(daoClassName);
        IDao dao = (IDao) daoClass.newInstance();

        String metierClassName = scanner.nextLine();
        Class metierClass = Class.forName(metierClassName);
        IMetier metier = (IMetier) metierClass.newInstance();

        Method method = metier.getClass().getMethod("setDao", IDao.class);
        method.invoke(metier, dao);
        System.out.println("Le résultat :" + metier.calcul());
    }
}
