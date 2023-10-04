public class Process implements Comparable<Process> {

    private int Pid,Prior,AT,BT,wt,tat;

    public void setBT(int bT) {
        BT = bT;
    }
    public void setPid(int pid) {
        Pid = pid;
    }
    public void setPrior(int prior) {
        Prior = prior;
    }
    public int getBT() {
        return BT;
    }
    public int getPid() {
        return Pid;
    }
    public int getPrior() {
        return Prior;
    }
    public void setAT(int aT) {
        AT = aT;
    }
    public int getAT() {
        return AT;
    }
    public void setWt(int wt) {
        this.wt = wt;
    }
    public int getWt() {
        return wt;
    }
    public void setTat(int tat) {
        this.tat = tat;
    }
    public int getTat() {
        return tat;
    }
    @Override
    public int compareTo(Process o) {
        return this.AT - o.AT;
    }

}
