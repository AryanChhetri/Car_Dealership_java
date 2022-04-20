class Branch extends Dealership{
    public int manager_id=0;
    public int employee_id[]={1};
    String city;
    String address="";
    Branch(int bid,int mid, String addr,String city){
        super(bid);
        manager_id=mid;
        address = addr;
        this.city=city;
    }
}