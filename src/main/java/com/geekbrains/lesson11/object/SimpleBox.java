package com.geekbrains.lesson11.object;

public class SimpleBox {
    private Object obj;
    public Object getObj() {
        return obj;
    }
    public void setObj(Object obj) { this.obj = obj;
    }
    public SimpleBox(Object obj) { this.obj = obj;
    }
}
