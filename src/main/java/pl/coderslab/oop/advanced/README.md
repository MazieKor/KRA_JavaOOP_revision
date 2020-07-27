![Coders-Lab-1920px-no-background](https://user-images.githubusercontent.com/152855/73064373-5ed69780-3ea1-11ea-8a71-3d370a5e7dd8.png)


## Zadanie 1 - rozwiązywane z wykładowcą

Do klasy ```AdvancedCalculator``` dopisz:

 1. stałą ```PI```, która będzie miała przypisaną wartość **3.14159265**,
 2. statyczną metodę ```computeCircleArea(r)``` , która będzie zwracała pole koła. Ta metoda nie będzie dopisywać obliczeń do tablicy (napisz w komentarzu, dlaczego nie może tego robić),
 3. statyczną tablicę, która będzie przechowywała historię operacji wykonanych na wszystkich kalkulatorach,
 4. statyczną metodę `printGlobalOperations()`, która będzie wyświetlała wszystkie operacje ze wszystkich obiektów klasy `Calculator`.

## Zadanie 2

Do klasy ```AdvancedCalculator``` dopisz:

1. przeciążoną metodę `printGlobalOperations(int length)`, która wyświetli określoną liczbę ostatnich operacji,
2. przeciążoną metodę `printGlobalOperations(String length)`, która wyświetli określoną liczbę ostatnich operacji.
Wykonaj rzutowanie wartości typu `String`. Napisz obsługę odpowiedniego wyjątku.

## Zadanie 3

Napisz podstawę programu obiektowego, który będzie wspomagać skanowanie produktów w sklepie.

Stwórz klasę `Product`. Klasa ma posiadać poniższe atrybuty:
  * `id` – liczba całkowita. Powinna być unikalna w całym systemie (w dalszej części zadania zostanie wyjaśnione jak to osiągnąć),
  * `name` –  typu String, jest to nazwa danego produktu,
  * `price` – typu double, jest to cena za jeden produkt. Powinna być większa od `0.01`. Sprawdź ten warunek w setterze utworzonym własnoręcznie. Jeśli warunek nie będzie spełniony – zwróć wyjątek.


#### Generowanie kolejnego id dla produktu:  

W dalszej części programu będziemy chcieli identyfikować nasze produkty po ich **id**, dlatego musimy zagwarantować, że każdy z utworzonych produktów będzie miał unikalny numer identyfikacyjny.
W tym celu powinniśmy zdefiniować zmienną klasową ```nextId```.

Zmienna ta będzie trzymała **id**, które zostanie nadane kolejnemu utworzonemu produktowi. Następnie w konstruktorze klasy musimy wykonać poniższe czynności:
  * każdemu tworzonemu produktowi przypisać **id** trzymane w zmiennej `nextId`,
  * zwiększyć wartość `nextId` o jeden.

```
//w konstruktorze
    this.id = nextId;
    nextId++;

```

Dzięki temu żaden z naszych produktów nie będzie miał takiego samego **id**.

## Zadanie 4

1. Utwórz klasę `CartItem` zawierającą dwa pola:
    * product – referencja do obiektu typu **Product**
    * quantity – (int) – ilość powyższego produktu w koszyku.

2. Uzupełnij klasę `ShoppingCart`. Klasa ta ma posiadać następujące atrybuty:
  * `cartItems` – tablica z obiektami klasy `CartItem`.

 Do tej zmiennej nie powinno być ustawionych ani getterów, ani setterów.

 Klasa powinna mieć też następujące metody:
 
  * `addProduct(Product product, int quantity)` – metoda ta powinna dodawać nowy obiekt `CartItem` do tablicy `cartItems`. Przy dodawaniu drugiego egzemplarza produktu pamiętaj o zwiększaniu jego ilości.
  * `removeProduct(Product product)` – metoda ta powinna usuwać wszystkie sztuki produktu z koszyka.
  * `updateProduct(Product product, int quantity)` – metoda ta powinna zmieniać ilość danego produktu w koszyku. 
  * `getTotalQuantity()` – metoda ta ma zwracać łączną ilość wszystkich produktów w koszyku. 
  * `getTotalSum()` – metoda ta ma zwracać łączną wartość wszystkich produktów w koszyku. 
  * `printReceipt()` – metoda drukująca paragon.  
  Na paragonie powinno się znaleźć: lista wszystkich produktów, wraz z ich id, nazwą, ceną, ilością i łączną ceną 
  ,łączna kwota za wszystkie produkty znajdujące się w koszyku. Zwracaj ciąg znaków w postaci:

```
1: Produkt 1, 2x2.5 = 5.0
2: Produkt 2, 3x12.0 = 36.0
3: Produkt 3, 1x1 = 1
---
Razem: 42.0
```

