public class StatePair <Type1 extends Comparable<Type1>, Type2 extends Comparable<Type2>> {
    private Type1 value1;
    private Type2 value2;
    
    public StatePair(Type1 x, Type2 y) {
        this.value1 = x;
        this.value2 = y;
    }

    public Type1 getType1() {
        return value1;
    }

    public Type2 getType2() {
        return value2;
    }

    public void setType1(Type1 value) {
        this.value1 = value;
    }

    public void setType2(Type2 value) {
        this.value2 = value;
    }
    
    public String printInfo() {
        return value1 + ": " + value2;
    }
 }