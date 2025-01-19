package homework3;

import java.util.Random;

public class TV {
     /*
    Формулировка задания:Реализовать класс Телевизор. У класса есть поля, свойства и методы. Проверить работу в классе homework3.App, методе main. Обратить внимание на переопределение метода toString.
    Ожидаемый результат:
    1. Создан класс Телевизор;
    2.  У класса есть поля, свойства и методы.  Поля желательно сделать private. Задать новые значения полям класса можно через конструктор и setters.
    3. В классе переопределен метод toString.
    4. Создан класс homework3.App с методом main.
    5. В методе main класса homework3.App создано несколько экземпляров класса Телевизор и проверено, как распечатываются заполненные данные об экземплярах класса.
    6. Дополнительно. Задавать параметры класса
     Телевизор с клавиатуры или случайным числом.
     */
    Random random = new Random();
    private final String TV_NAME = "Xiaomi";
    private final int MAX_CHANNELS = 3;
    private String color;
    private boolean hasWifiModule;
    private int currentChannel;
    private boolean powerIsOn;

    public TV (String color, boolean hasWifiModule){
        this.color = color;
        this.hasWifiModule = hasWifiModule;
        this.currentChannel = 1;
        this.powerIsOn = false;
    }

    public TV (){
        this.color = "Black";
        this.hasWifiModule = false;
        this.currentChannel = 1;
        this.powerIsOn = false;
    }

    public void setColor(String color){
        this.color = color;
    }

    public void setWifiModule(boolean hasWifiModule){
        this.hasWifiModule = hasWifiModule;
    }
    public void setChannel(int channel){
        if (channel > 0 && channel <= MAX_CHANNELS) {
            this.currentChannel = channel;
            System.out.println("Канал переключен, текущий канал : " + channel);
        } else {
            System.out.println("Канал не переключен, максимальное количество каналов: " + MAX_CHANNELS);
        }
    }

    public String getName(){
        return this.TV_NAME;
    }
    public int getMaxChannels(){
        return this.MAX_CHANNELS;
    }
    public String getColor(){
        return this.color;
    }
    public boolean getHasWifiModule(){
        return this.hasWifiModule;
    }
    public int getCurrentChannel(){
        return this.currentChannel;
    }
@Override
    public String toString(){
        return "homework3.TV name: " + TV_NAME + "; max channels: " + MAX_CHANNELS + "; color: " + color + "; has wifi module?: " + hasWifiModule;
    }


    public String viewChannel(int currentChannel){
        String currentProgram = "Пшшшшшшшш. Настройте телевизор!!!";
        switch (currentChannel){
            case 1 -> {
                currentProgram = "Крутите барабан! Сектор приз на барабане! И главный приз - АВТОМОБИЛЬ!!!";
            }
            case 2 -> {
                currentProgram = "Игорь без спроса переключил канал и получил топором по голове от тещи. Впрочем, это уже совсем другая история";
            }
            case 3 -> {
                currentProgram = "Профилактика";
            }
        }
        return currentProgram;
    }

    public void powerOn (int channel){
        powerIsOn = random.nextBoolean();
        if(powerIsOn){
            this.currentChannel = channel;
            System.out.println(viewChannel(currentChannel));

        } else {
            System.out.println("Телевизор не включается. Иди чини!!!");
        }
    }

    public void powerOn (){
        powerIsOn = random.nextBoolean();
        if(powerIsOn){
            System.out.println(viewChannel(currentChannel));
        } else {
            System.out.println("Телевизор не включается. Иди чини!!!");
        }
    }
    public void powerOff (){
       if (powerIsOn){
           powerIsOn = false;
           System.out.println("Телевизор выключен.");
       } else {
           System.out.println("Телевизор не включен..");
       }

    }


}
