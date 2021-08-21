![Coders-Lab-1920px-no-background](https://user-images.githubusercontent.com/152855/73064373-5ed69780-3ea1-11ea-8a71-3d370a5e7dd8.png)


#Draft version of readme
Task includes Class AdvancedCalculator from this package, as well as classes Claculator and TestCalculator from package 'constructor'. Elements of task are also used by classes Shape and Circle (from this package)
Task shpuld encompass topics like inheritance, polymorphism and static fields/ methods, as well as invoking them. 
Task was based on class Calculator which I created with 6 basic methods (add, subtract, multiply, divide, printOperations, clearOperations). The idea behind this task and Class is that the mathematical operations are performed, some validation made (division through 0) and result are remembered. For that an array (instance field of the class) is used. Remebered operations can also be erased (eg. to start the array from beginning and new operations on).
To this basic class an AdvancedCalculator class (which extended Calculator class), in different package was added. In this method further method are provided (power, root), and operation still need to be remembered in the same array (since arrays is private field getter and setter are used).
Furthermore in AdvancedCalculator should be created method which remembers all operations (on all calculators) – so static array field must be created to remember all operations (because these field and method are static I can use them from class Calculator without creating any AdvancedCalculator object first – thorugh  ‘AdvancedCalculator.getTabStatic();’ I can get ‘global’ array from other class). Static methods inter alia to print all/ defined number of last/ operations from static array were added + some basic validation (parsing String to integer according with task content. I did it with Scanner class for exercise diiferent way of parsing).
In the end I created TestCalculator class where I tested methods of classes Calculator and AdvancedCalculator, as well as arrays (‘global’ static one and instance one), which should save operations, with different numbers (including 0).

Besides, in accordance with other tasks, I created 2 classes (Shape and Circle which extended Shape), which have methods (eg. getArea() ), which in turn take advantage of methods from AdvancedCalculator class. Those methods (which uses methods from AdvancedCalculator class) where tested in class TestClass, co AdvancedCalculator class was checked “in real life”



## Zadanie 1 - rozwiązywane z wykładowcą

Stwórz klasę ```AdvancedCalculator```, która dziedziczy po klasie ```Calculator```.
Klasa powinna implementować następujące metody:

1. ```pow(num1, num2)``` &ndash; metoda ma zwracać ```num1``` do potęgi ```num2```. 
Dodatkowo w tablicy operacji ma zapamiętać napis: "```num1```^```num2``` equals ```result```".
2. ```root(num1, num2)``` &ndash; metoda ma wyliczyć pierwiastek ```num2``` stopnia z ```num1```. 
Dodatkowo w tablicy operacji ma zapamiętać napis: "```num2``` root of ```num1``` equals ```result```".  

## Zadanie 2

Stwórz klasę `Shape`, która będzie posiadała:

1. prywatne atrybuty `x` i `y` (określające środek tego kształtu) oraz `color`,
2. konstruktor, przyjmujący zmienne określające wartości `x`, `y` i `color`, 
3. metodę o nazwie `getDescription()`, wypisującą informacje o tym kształcie, zwracającą wartość typu `String`,
4. metodę o nazwie `getDistance(Shape shape)`, zwracającą odległość od środka innego kształtu, wynik ma być typu `double`.

Sprawdź, co się dzieje, kiedy zmieniasz dostęp do poszczególnych funkcji z publicznego na prywatny.  

## Zadanie 3

Stwórz klasę `Circle`, która spełnia następujące wymogi:

1. dziedziczy po klasie definiującej kształt (`Shape`),
2. ma dodatkowy atrybut `radius`,
3. posiada konstruktor, przyjmujący zmienne określające wartości `x`, `y`, `color` i `radius`,
4. nadpisuje metodę kształtu – `getDescription()`,
5. ma metodę o nazwie `getArea()`, zwracającą pole powierzchni typu `double`,
6. posiada metodę o nazwie `getCircuit()`, zwracającą obwód typu `double`.

Przetestuj metodę `getDistance(Shape shape)` na obiektach typu `Circle`.

## Zadanie 4

Stwórz klasę `Employee`, która posiada:

1. publiczne atrybuty:
 * `id` – atrybut zawierający informację o numerze identyfikacyjnym pracownika,
 * `firstName` – atrybut określający imię pracownika,
 * `lastName` – atrybut określający nazwisko pracownika,
 * `wage` – atrybut określający stawkę godzinową pracownika,
2. konstruktor przyjmujący: id, imię, nazwisko i stawkę za godzinę,
3. metodę `raiseWage(percent)`, której rolą będzie zwiększenie wartości atrybutu `wage` o podany procent.  
Pamiętaj o sprawdzeniu czy podana wartość jest większa lub równa 0.

## Zadanie 5

Stwórz klasę `HourlyEmployee`, reprezentującą pracownika, któremu pracodawca płaci za godziny.
Klasa ma spełniać następujące wymogi:

1. ma dziedziczyć po klasie `Employee`,
2. posiadać dodatkową metodę `calculatePayment(hours)`, która będzie zwracała kwotę do wypłacenia pracownikowi za liczbę wypracowanych godzin. 

## Zadanie 6

Stwórz klasę `SalariedEmployee` reprezentującą pracownika, z którym pracodawca ma umowę miesięczną.
Klasa powinna:

1. dziedziczyć po klasie `Employee`,
2. mieć dodatkową metodę `calculatePayment()`, która będzie zwracała kwotę do wypłacenia pracownikowi za miesiąc
 (dla uproszczenia możemy założyć, że w każdym miesiącu jest 190 godzin pracujących – użyj `final static`). 
