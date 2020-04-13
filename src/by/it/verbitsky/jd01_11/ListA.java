package by.it.verbitsky.jd01_11;

import java.util.*;
import java.util.function.UnaryOperator;

class ListA<T> implements List<T> {
    private T[] elements = (T[]) new Object[]{};

    public T[] getElements() {
        return elements;
    }

    private int size = 0;

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder("[");
        for (int i = 0, elementsLength = size; i < elementsLength; i++) {
            T element = elements[i];
            sb.append(element).append(", ");
        }
        sb.deleteCharAt(sb.length() - 1);
        sb.setCharAt(sb.length() - 1, ']');
        return sb.toString();
    }

    @Override
    public boolean add(T element) {
        if (size == elements.length) {
            elements = Arrays.copyOf(elements, elements.length * 3 / 2 + 1);
        }
        elements[size++] = element;
        return true;//возвращает успех операции вставки
    }

    @Override
    public T get(int index) {
        return elements[index];
    }

    @Override
    public T remove(int index) {
        T ret = elements[index];
        //копируем массив от удаляемого элемента до конца в позицию index = позиция удаляемого элемента
        System.arraycopy(elements, index + 1, elements, index, (size - index - 1));
        size--;
        return ret;
    }

    @Override
    public int size() {
        return this.size;
    }

    //--------------------------Stubs
    @Override
    public void replaceAll(UnaryOperator<T> operator) {

    }

    @Override
    public void sort(Comparator<? super T> c) {

    }

    @Override
    public Spliterator<T> spliterator() {
        return null;
    }

    @Override
    public boolean isEmpty() {
        return false;
    }

    @Override
    public boolean contains(Object o) {
        return false;
    }

    @Override
    public Iterator<T> iterator() {
        return null;
    }

    @Override
    public Object[] toArray() {
        return new Object[0];
    }

    @Override
    public <T1> T1[] toArray(T1[] a) {
        return null;
    }


    @Override
    public boolean remove(Object o) {
        return false;
    }

    @Override
    public boolean containsAll(Collection<?> c) {
        return false;
    }

    @Override
    public boolean addAll(Collection<? extends T> c) {
        return false;
    }

    @Override
    public boolean addAll(int index, Collection<? extends T> c) {
        return false;
    }

    @Override
    public boolean removeAll(Collection<?> c) {
        return false;
    }

    @Override
    public boolean retainAll(Collection<?> c) {
        return false;
    }

    @Override
    public void clear() {

    }


    @Override
    public T set(int index, T element) {
        return null;
    }

    @Override
    public void add(int index, T element) {

    }


    @Override
    public int indexOf(Object o) {
        return 0;
    }

    @Override
    public int lastIndexOf(Object o) {
        return 0;
    }

    @Override
    public ListIterator<T> listIterator() {
        return null;
    }

    @Override
    public ListIterator<T> listIterator(int index) {
        return null;
    }

    @Override
    public List<T> subList(int fromIndex, int toIndex) {
        return null;
    }
}
