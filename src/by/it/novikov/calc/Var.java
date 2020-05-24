package by.it.novikov.calc;

import java.util.HashMap;
import java.util.Map;

abstract class Var implements Operation {

    private static Map<String,Var> map=new HashMap<>();

    @Override
    public Var add(Var other) throws CalcException {
        throw new CalcException(String.format("Operation %s + %s is impossible\n",this,other));
    }

    @Override
    public Var sub(Var other) throws CalcException {
        throw new CalcException(String.format("Operation %s - %s is impossible\n",this,other));
    }

    @Override
    public Var mul(Var other) throws CalcException {
        throw new CalcException(String.format("Operation %s * %s is impossible\n",this,other));
    }

    @Override
    public Var div(Var other) throws CalcException {
        throw new CalcException(String.format("Operation %s / %s is impossible\n",this,other));
    }

    @Override
    public String toString() {
        return "Abstract Var";
    }

    static Var createVar(String strVar) throws CalcException {
        if (strVar.matches(Patterns.SCALAR))
            return new Scalar(strVar);
        else {
            Var var = map.get(strVar);
            if (var!=null)
                return var;
            else
                throw new CalcException("incorrect name var: "+strVar);
        }
    }

    public static void save(String name, Var var) {
        map.put(name,var);
    }
}