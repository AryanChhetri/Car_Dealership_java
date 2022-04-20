class Salesperson extends Employee{
    float rating;
    int [] cust_id=new int[6];
    Salesperson(int b_id,int e_id,int cust_id[],float rating){
        super(b_id, e_id);
        this.cust_id=cust_id;
        this.rating=rating;
    }
    public void view_vehicles(){

    }

    public take_order(){
        
    }

    public present_quotation(){

    }

}