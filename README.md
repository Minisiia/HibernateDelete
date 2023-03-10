## HibernateDelete
In the BookHelper class add methods for deleting a book by id and by author.
## 6. JDBC & Hibernate 6. Advanced Hibernate
## Задание 3 

В класс BookHelper пакета ex_004_relations дописать методы удаления книге по id и по автору.

## Заметки

**CriteriaQuery и CriteriaDelete**

CriteriaQuery и CriteriaDelete - это два разных класса в Criteria API, которые используются для выполнения разных типов запросов к базе данных.

CriteriaQuery используется для создания запросов на выборку данных из базы данных. Он предоставляет более гибкий и типобезопасный способ построения запросов к базе данных, чем использование прямых SQL-запросов. CriteriaQuery позволяет строить запросы динамически, добавляя условия, сортировки, объединения, выборки только необходимых полей и т.д.

CriteriaDelete, в свою очередь, используется для удаления данных из базы данных. Он также предоставляет более безопасный и типобезопасный способ удаления данных, чем использование прямых SQL-запросов. CriteriaDelete позволяет строить запросы динамически, добавляя условия для фильтрации удаляемых данных.

Оба класса используются вместе с CriteriaBuilder, который предоставляет методы для построения запросов с помощью Criteria API. Однако, CriteriaQuery и CriteriaDelete выполняют разные задачи и имеют разные методы для построения запросов.

Таким образом, можно сказать, что CriteriaQuery и CriteriaDelete отличаются своей целью: первый используется для выборки данных, в то время как второй - для удаления данных из базы данных.

**Удаление с помощью CriteriaDelete**

Для удаления книг по автору с помощью CriteriaBuilder вам необходимо выполнить несколько шагов:

1. Создайте экземпляр CriteriaBuilder и CriteriaDelete:

```java
CriteriaBuilder cb = session.getCriteriaBuilder();
CriteriaDelete<Book> cd = cb.createCriteriaDelete(Book.class);
```

2. Получите корневую сущность, к которой вы хотите применить критерии:

```java
Root<Book> root = cd.from(Book.class);
```

3. Определите условие, которое определяет, какие книги нужно удалить:

```java
cd.where(cb.equal(root.get("author"), author));
```

4. Добавьте условие к удалению и выполните запрос:

```java
Query query = session.createQuery(cd);
query.executeUpdate();
```

