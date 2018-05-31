package mx.unam.fi.sosa.electrostore.utilidades;

public class utilidades {
    public static final String TABLA_RESISTENCIAS="resistencias";
    public static final String TABLA_CAPACITORES="capacitores";
    public static final String TABLA_POTENCIOMETROS="potenciometros";
    public static final String TABLA_DIODOS="diodos";
    public static final String TABLA_LEDS="leds";
    public static final String TABLA_TRANSISTORES="transistores";
    public static final String TABLA_INTEGRADOS="integrados";
    public static final String TABLA_CABLES="cables";
    public static final String TABLA_OTROS="otros";

    public static final String CAMPO_VALOR_Res="valor";
    public static final String CAMPO_CANTIDAD_Res="cantidad";
    public static final String CAMPO_VALOR_Cap="valor";
    public static final String CAMPO_CANTIDAD_Cap="cantidad";
    public static final String CAMPO_VALOR_Pot="valor";
    public static final String CAMPO_CANTIDAD_Pot="cantidad";
    public static final String CAMPO_VALOR_Led="valor";
    public static final String CAMPO_CANTIDAD_Led="cantidad";
    public static final String CAMPO_VALOR_Dio="valor";
    public static final String CAMPO_CANTIDAD_Dio="cantidad";
    public static final String CAMPO_VALOR_Tra="valor";
    public static final String CAMPO_CANTIDAD_Tra="cantidad";
    public static final String CAMPO_VALOR_Int="valor";
    public static final String CAMPO_CANTIDAD_Int="cantidad";
    public static final String CAMPO_VALOR_Cab="valor";
    public static final String CAMPO_CANTIDAD_Cab="cantidad";
    public static final String CAMPO_VALOR_Otr="valor";
    public static final String CAMPO_CANTIDAD_Otr="cantidad";

    public static final String CREAR_TABLA_RESISTENCIAS="CREATE TABLE "+TABLA_RESISTENCIAS+" ("+CAMPO_VALOR_Res+" TEXT, "+CAMPO_CANTIDAD_Res+" TEXT)";
    public static final String CREAR_TABLA_CAPACITORES="CREATE TABLE "+TABLA_CAPACITORES+" ("+CAMPO_VALOR_Cap+ " TEXT, "+CAMPO_CANTIDAD_Cap+ " TEXT)";
    public static final String CREAR_TABLA_POTENCIOMETROS="CREATE TABLE "+TABLA_POTENCIOMETROS+" ("+CAMPO_VALOR_Pot+ " TEXT, "+CAMPO_CANTIDAD_Pot+ " TEXT)";
    public static final String CREAR_TABLA_LEDS="CREATE TABLE "+TABLA_LEDS+" ("+CAMPO_VALOR_Led+ " TEXT, "+CAMPO_CANTIDAD_Led+ " TEXT)";
    public static final String CREAR_TABLA_DIODOS="CREATE TABLE "+TABLA_DIODOS+" ("+CAMPO_VALOR_Dio+ " TEXT, "+CAMPO_CANTIDAD_Dio+ " TEXT)";
    public static final String CREAR_TABLA_TRANSISTORES="CREATE TABLE "+TABLA_TRANSISTORES+" ("+CAMPO_VALOR_Tra+ " TEXT, "+CAMPO_CANTIDAD_Tra+ " TEXT)";
    public static final String CREAR_TABLA_INTEGRADOS="CREATE TABLE "+TABLA_INTEGRADOS+" ("+CAMPO_VALOR_Int+ " TEXT, "+CAMPO_CANTIDAD_Int+ " TEXT)";
    public static final String CREAR_TABLA_CABLES="CREATE TABLE "+TABLA_CABLES+" ("+CAMPO_VALOR_Cab+ " TEXT, "+CAMPO_CANTIDAD_Cab+ " TEXT)";
    public static final String CREAR_TABLA_OTROS="CREATE TABLE "+TABLA_OTROS+" ("+CAMPO_VALOR_Otr+ " TEXT, "+CAMPO_CANTIDAD_Otr+ " TEXT)";

}
