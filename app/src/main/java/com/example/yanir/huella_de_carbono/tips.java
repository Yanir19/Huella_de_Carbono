package com.example.yanir.huella_de_carbono;

import java.util.Vector;

/**
 * Created by LjnozZ on 13/06/2015.
 */
public class tips {

    Vector<String> tips_carro = new Vector<String>();
    Vector<String> tips_casa = new Vector<String>();
    Vector<String> tips_luz = new Vector<String>();
    Vector<String> tips_cocina = new Vector<String>();
    Vector<String> tips_comida = new Vector<String>();
    Vector<String> tips_laptop = new Vector<String>();
    Vector<String> tips_amarilla = new Vector<String>();
    Vector<String> tips_negra = new Vector<String>();
    Vector<String> tips_roja = new Vector<String>();
    Vector<String> tips_naranja = new Vector<String>();
    Vector<String> tips_verde = new Vector<String>();

    Vector<String> que_es_la_huella = new Vector<String>();
    Vector<String> como_se_calcula = new   Vector<String>() ;


    public tips() {

    }

    public Vector agregarTips(int tipo){
        switch (tipo)  {
            case 1:
                tips_carro.add("Mantenga bien infladas y calibradas las llantas de su carro. Esta acción le permite ahorrar gasolina, además el motor no la quema en exceso.");
                tips_carro.add("Para pequeños desplazamientos dentro de la ciudad considere la posibilidad de ir a pie en bicicleta o en transporte público.");
                tips_carro.add("No acelere el motor en frío innecesariamente. La consecuencia es un elevado desgaste del motor y un gran consumo de combustible.");
                tips_carro.add("Mantener la velocidad de circulación lo más uniforme posible, evitar aceleraciones, y cambios de marchas innecesarios, ahorra combustible.");
                tips_carro.add("Conducir por carretera con las ventanas abiertas y el aire acondicionado encendido puede aumentar el consumo en un 5 por ciento.");
                tips_carro.add("No lleves un portaequipajes vacío. Esto aumenta el consumo de combustible y las emisiones de CO2 hasta en un 10% debido a la resistencia del viento y al peso adicional.");
            return tips_carro;

            case 2:
                tips_casa.add("Reducir el volumen de basura generada, ya sea a través del reciclado o de la compra sustentable, permite reducir emisiones.");
                tips_casa.add("El vidrio es reciclable al 100%. Por cada botella que se recicla se ahorra la energía necesaria para mantener un televisor encendido durante 3 horas.");
                tips_casa.add("La fabricación del aluminio es uno de los procesos industriales de mayor consumo energético y de mayor impacto ambiental. Modere la utilización de papel de aluminio.");
                tips_casa.add("La bolsa de plástico que traemos de la compra se puede reutilizar como bolsa de la basura.");
                tips_casa.add("Los residuos son una fuente potencial de energía y materias primas que puede aprovecharse. De hecho, gran parte de la basura que se genera es recuperable o reciclable.");
            return tips_casa;

            case 3:
                tips_cocina.add("No seque la ropa de algodón y la ropa pesada en las mismas cargas de secado que la ropa ligera. Estas últimas se secan antes.");
                tips_cocina.add("Secar la ropa significa un gran consumo de energía. Es recomendable limitar su uso a situaciones de urgencia. Si emplea la función de secado del lavarropas, centrifugue previamente la ropa para no hacerla trabajar más.");
                tips_cocina.add("Apague el horno un poco antes de finalizar su cocción, el calor residual será suficiente para acabar el proceso.");
                tips_cocina.add("Evite abrir la puerta del horno innecesariamente. Cada vez que la abre se pierde, como mínimo, el 20% del calor acumulado en su interior.");
                tips_cocina.add("Procure que el fondo de los recipientes sea ligeramente superior al fuego o zona de cocción: aprovechará al máximo el calor de la cocina. Tape las cacerolas durante la cocción: consumirá menos energía.");
                tips_cocina.add("Abra la puerta lo menos posible y ciérrela rápidamente: unos segundos bastan para perder buena parte del frío acumulado.");
                tips_cocina.add("Utilizar un colgador/tendedero en vez de una secadora de ropa. Si se seca la ropa al aire libre la mitad del año, se reduce en 320 kilos la emisión de dióxido de carbono al año.");
            return tips_cocina;

            case 4:
                tips_laptop.add("Use tubos fluorescentes donde necesite más luz y esté encendida muchas horas; por ejemplo, en la cocina.");
                tips_laptop.add("Sustituya las lamparas incandescentes por lámparas de bajo consumo. Para un mismo nivel de iluminación, ahorran hasta un 80% de energía y duran 8 veces más.");
                tips_laptop.add("Mantenga limpias las lámparas y las pantallas, aumentará  la luminosidad sin aumentar la potencia.");
                tips_laptop.add("Cuando renueves tu lavadora o refrigerador, prefiere aquellos que tengan etiquetado energético clase A y podrás ahorrar hasta 185 kg CO2-e al año.");
                tips_laptop.add("No dejes los aparatos eléctricos en modo stand-by (espera). Utiliza la función on/off del propio aparato.");
                tips_laptop.add("Desenchufa el cargador del teléfono cuando no lo utilices. Incluso cuando no está conectado al teléfono, consume electricidad.");
                tips_laptop.add("Plancha la ropa de una vez. Y no una prenda ahora y otra más tarde. Así ahorrarás la energía que se consume en calentar la plancha cada vez que la utilizas.");
            return tips_laptop;

            case 5:
                tips_luz.add("Por cada grado que aumentas la temperatura de la calefacción puedes aumentar el consumo de energía en un 5 a 7 por ciento y, por tanto, en la misma proporción las emisiones de CO2 derivadas de dicho consumo.");
                tips_luz.add("El ciclo completo de fabricar una botella a partir de vidrio reciclado consume alrededor de 1,7 veces menos energía que a partir de materias primas y genera 2,6 veces menos emisiones a la atmósfera de CO2.");
                tips_luz.add("Una tonelada de basura orgánica permite recuperar en forma de energía eléctrica alrededor de 160 kWh, el equivalente al consumo de una bombilla de 50 W en dos años.");
                tips_luz.add("Un ciudadano medio produce en promedio 1,3 kilos de basura doméstica diaria, de los cuales el 50 por ciento está formada por envases de productos que van a parar a vertederos.");
                tips_luz.add("Las emisiones derivadas del uso de vehículos de transporte por carretera se estima que suponen un 48 por ciento del total de emisiones causadas por el consumo de energía final.");
                tips_luz.add("El pais que produce mas emisiones de CO2 es China, que tiene el 30% de las emisiones globales, y podrían duplicarse para el 2040.");
                tips_luz.add("Las emisiones de CO2 de Venezuela por habitante son las más altas de América Latina :( .");
                tips_luz.add("Un televisor que permanece encendido durante 3 horas al día  y en modo stand-by las 21 horas restantes, consumirá aproximadamente el 40% de la energía total en el modo stand-by.");
            return tips_luz;

            case 6:
                tips_comida.add("Comprar alimentos frescos. Producir comida congelada consume 10 veces más energía.");
                tips_comida.add("Evitar comprar productos envasados. Si se reduce en un 10% la basura personal se puede ahorrar 540 kilos de dióxido de carbono al año.");
                tips_comida.add("Si compramos productos locales en vez de importamos disminuimos de forma considerable la emisión a la atmósfera de CO2 ya que reducimos el transporte necesario para la distribución de los productos.");
                tips_comida.add("Intenta reducir el consumo de carne a favor de productos vegetales ya que para producir un kilo de carne es necesario mucho más terreno, suelo fértil y agua que para producir un kilo de vegetales.");
                tips_comida.add("Compra productos a granel y evita el exceso de envases. Estaremos reduciendo el CO2 que se emite en la producción de plásticos y reduciremos el volumen de residuos.");
            return tips_comida;

            case 7:
                que_es_la_huella.add("La huella de carbono es una de las formas más simples que existen de medir el impacto o la marca que deja una persona sobre el planeta en su vida cotidiana.");
                que_es_la_huella.add("Es un recuento de las emisiones de dióxido de carbono (CO2), que son liberadas a la atmósfera debido a nuestras actividades cotidianas.");
                que_es_la_huella.add("Es la medida del impacto que provocan las actividades del ser humano y se determina según la cantidad de emisiones de Gases de Efecto Invernadero (GEI) producidos, medidos en unidades de CO2 equivalente.");
            return que_es_la_huella;

            case 8:
                como_se_calcula.add("A la hora de calcular la huella de carbono hay que tener en cuenta todas las variables de la vida cotidiana: alojamiento, transporte, alimentación  y consumo (equipos tecnológico, entretenimiento, etc).");
                como_se_calcula.add("La huella de carbono se mide en toneladas de CO2 equivalente (tCO2e), y se calcula multiplicando los datos de las actividades (cantidad) por factores de emisión.");
                como_se_calcula.add("Los factores de emisión se determinan por organismos e instituciones y hay distintos factores de emision dependiendo de lo que genere el CO2 (Combustibles, electricidad, etc). ");
            return como_se_calcula;

            case 9://PATICA AMARILLA
                tips_amarilla.add("No lleves un portaequipajes vacío. Esto aumenta el consumo de combustible y las emisiones de CO2 hasta en un 10% debido a la resistencia del viento y al peso adicional.");
                tips_amarilla.add("Sustituya las lamparas incandescentes por lámparas de bajo consumo. Para un mismo nivel de iluminación, ahorran hasta un 80% de energía y duran 8 veces más.");
                return tips_amarilla;

            case 10://PATICA NARANJA
                tips_naranja.add("La fabricación del aluminio es uno de los procesos industriales de mayor consumo energético y de mayor impacto ambiental. Modere la utilización de papel de aluminio.");
                tips_naranja.add("No dejes los aparatos eléctricos en modo stand-by (espera). Utiliza la función on/off del propio aparato.");

                return tips_naranja;

            case 11://PATICA NEGRA
                tips_negra.add("Los residuos son una fuente potencial de energía y materias primas que puede aprovecharse. De hecho, gran parte de la basura que se genera es recuperable o reciclable.");
                tips_negra.add("Compensa tus emisiones de CO2, una forma de hacerlo es sembrar árboles.");
                return tips_negra;

            case 12://PATICA ROJA
                tips_roja.add("Para pequeños desplazamientos dentro de la ciudad considere la posibilidad de ir a pie en bicicleta o en transporte público.");
                tips_roja.add("Secar la ropa significa un gran consumo de energía. Es recomendable limitar su uso a situaciones de urgencia. Si emplea la función de secado del lavarropas, centrifugue previamente la ropa para no hacerla trabajar más.");


                return tips_roja;
            case 13://PATICA VERDE
                tips_verde.add("Desenchufa el cargador del teléfono cuando no lo utilices. Incluso cuando no está conectado al teléfono, consume electricidad.");
                tips_verde.add("Mantenga bien infladas y calibradas las llantas de su carro. Esta acción le permite ahorrar gasolina, además el motor no la quema en exceso.");
                return tips_verde;


        }



        return tips_carro;
    }



}
