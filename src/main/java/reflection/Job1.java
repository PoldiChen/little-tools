package reflection;

/**
 * @author poldi.chen
 * @className Job1
 * @description TODO
 * @date 2020/5/4 22:11
 **/
@MyInnotation
public class Job1 implements IJobInter {

    @Override
    public void execute(String param) {
        System.out.println("execute job1");
        System.out.println(param);
    }
}
