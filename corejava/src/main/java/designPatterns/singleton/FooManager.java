package designPatterns.singleton;

class FooManager{}

class FooManager1 { 
    private static volatile FooManager bar = null; 
    public static FooManager getInstance() { 
        if (bar == null) { 
            synchronized(FooManager.class) {
                if (bar == null) 
                    bar = new FooManager();  
            } 
        } 
        return bar; 
    } 
} 

class FooManager2 {
    private static final FooManager INSTANCE = new FooManager(); 
    private FooManager2() { 
        if (INSTANCE != null) { 
                throw new IllegalStateException("Already instantiated"); 
        } 
    } 
    public static FooManager getInstance() { 
        return INSTANCE; 
    } 
} 


