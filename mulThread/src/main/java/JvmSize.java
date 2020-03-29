/**
 * @ClassName T
 * @Description: TODO
 * @Author HaosionChiang
 * @Date 2020/3/28
 * @Version V1.0
 **/
public class JvmSize {
    public static void main(String[] args) {
        //cpu逻辑处理器个数
        System.out.println(Runtime.getRuntime().availableProcessors());

        //返回 Java虚拟机试图使用的最大内存量。物理内存的1/4（-Xmx）
        long maxMemory = Runtime.getRuntime().maxMemory() ;
        //返回 Java虚拟机中的内存总量(初始值)。物理内存的1/64（-Xms）
        long totalMemory = Runtime.getRuntime().totalMemory() ;
        System.out.println("MAX_MEMORY =" + maxMemory +"(字节)、" + (maxMemory / (double)1024 / 1024) + "MB");
        System.out.println("DEFALUT_MEMORY = " + totalMemory + " (字节)、" + (totalMemory / (double)1024 / 1024) + "MB");

    }
}
