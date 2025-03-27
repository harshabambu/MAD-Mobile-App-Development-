package com.example.recycler;

public class Department {
    int dpic;
    String dname;
    String dseats;

    public Department(int dpic, String dname, String dseats) {
        this.dpic = dpic;
        this.dname = dname;
        this.dseats = dseats;
    }

    public int getDpic() {
        return dpic;
    }

    public String getDname() {
        return dname;
    }

    public String getDseats() {
        return dseats;
    }

    public void setDpic(int dpic) {
        this.dpic = dpic;
    }

    public void setDseats(String dseats) {
        this.dseats = dseats;
    }

    public void setDname(String dname) {
        this.dname = dname;
    }
}
