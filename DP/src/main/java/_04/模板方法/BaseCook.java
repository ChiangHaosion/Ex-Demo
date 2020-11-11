package _04.模板方法;

/**
 * @Author HaosionChiang
 * @Date 2020/10/17
 **/
public abstract class BaseCook {

    public abstract void oil();

    public abstract void eggs();

    public abstract void totamo();


    public final void cooks() {

        if (this.isAddOil()) {
            this.oil();
        }

        this.eggs();
        this.totamo();


    }


    /**
     * 钩子方法, 让子类决定
     */

    public boolean isAddOil() {
        return true;
    }
}
