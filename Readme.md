# **Задача №1. Обновляемый список транзакций**

Необходимо написать приложение (состоящее из одного экрана), которое отображает список транзакций, полученных с сервера. Условия следующие:

- Транзакции должны сохраняться в локальном хранилище. При старте приложения без интернета, должны отображаться все транзакции, которые были получены до этого.
- Список транзакций должен быть упорядоченным (сверху самые старые, снизу самые новые)
- Список должен быть сгруппирован по минутам (перед каждой группой должен быть заголовок со временем в формате HH:mm, как на [картинку](https://racoon.zoomag.ru/img/dummy/task1_transactions.png))
- Список должен обновляться каждые 10 секунд (для этого каждые 10 секунд можно делать запрос к серверу, который вернет новые транзакции, а также те, чьи статусы были изменены)
- При добавлении и обновлении транзакций весь список не должен перерисовываться (только необходимые элементы).
- Каждый элемент списка (транзакция) должен содержать: тип транзакции, статус (иконка), сумму, идентификатор (id), время создания в формате DD MMM HH:mm:ss

*Для получения транзакций можно использовать метод: GET [/dummy/transaction](https://racoon.zoomag.ru/dummy/transaction)Для сброса списка транзакций перед получением новых: GET [/dummy/transaction?clear=true](https://racoon.zoomag.ru/dummy/transaction?clear=true)Параметр транзакции status имеет одно из значений IN_PROGRESS|SUCCESS|FAILUREПараметр транзакции type имеет одно из значений CASH|CARD|BANK|CARD_TO_CARD*

**Задание желательно выполнить в архитектуре MVVM, с ипользованием Room и Retorfit.**

**Скриншоты:**


<p float="left">
  <img src="https://github.com/antrdima/TransactionsApp/blob/master/screenshots/image1.png" width="300" />
  <img src="https://github.com/antrdima/TransactionsApp/blob/master/screenshots/image2.png" width="300" /> 
</p>