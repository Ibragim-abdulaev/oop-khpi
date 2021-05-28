package ua.khpi.oop.abdulaev05;
import java.io.*;
import java.util.Iterator;
/**
 * Клас контейнер
 */
public class Container {

    private String[] arr;

    public Container() {
        arr = new String[]{};
    }

    public String toString() {
        StringBuilder builder = new StringBuilder();
        for (String s : arr)
            builder.append(s).append(" ");
        return builder.toString();
    }

    public void add(String str) {
        int i;
        String[] oldArr = arr;
        arr = new String[oldArr.length + 1];
        for (i = 0; i < oldArr.length; i++)
            arr[i] = oldArr[i];
        arr[i] = str;
    }

    public void clear() {
        arr = new String[]{};
    }

    public boolean remove(String str) {
        String[] oldArr = arr;
        if (!contains(str)) return false;
        arr = new String[oldArr.length - 1];
        for (int i = 0, j = 0; i < oldArr.length; i++)
            if (!oldArr[i].contains(str))
                arr[j++] = oldArr[i];
        return true;
    }

    public Object[] toArray() {
        return arr;
    }

    public int size() {
        return arr.length;
    }

    public boolean contains(String str) {
        for (String s : arr)
            if (s.equals(str)) return true;

        return false;
    }

    public boolean containsAll(Container list) {
        int i, j;
        for (i = 0; i < list.size(); i++) {
            for (j = 0; j < arr.length; j++)
                if (list.arr[i].equals(arr[j])) break;
            if (j == arr.length) return false;
        }
        return true;
    }

    public void read(String filePath) {
        try {
            FileInputStream fileInputStream = new FileInputStream(filePath.replace("file:", ""));
            ObjectInputStream objectInputStream = new ObjectInputStream(fileInputStream);

            arr = (String[]) objectInputStream.readObject();
        } catch (IOException | ClassNotFoundException e) {
            System.out.println("File not found " + filePath);
        }
    }


    public void write(String filePath) {
        try {
            FileOutputStream outputStream = new FileOutputStream(filePath.replace("file:", ""));
            ObjectOutputStream objectOutputStream = new ObjectOutputStream(outputStream);

            objectOutputStream.writeObject(arr);
            objectOutputStream.close();
        } catch (IOException e) {
            System.out.println("File not found " + filePath);
        }
    }

    public String[] find(String str) {
        String[] results = new String[]{};

        if (str == null) return results;

        for (String s : arr) {
            if (s.contains(str)) {
                String[] _re = results;
                results = new String[_re.length + 1];
                int i;

                for (i = 0; i < _re.length; i++)
                    results[i] = _re[i];

                results[i] = s;
            }
        }

        return results;
    }

    public void sort(int sb) {
        int i, j;
        String tmp;

        switch (sb) {
            case 1:
                for (i = 0; i < arr.length; i++) {
                    for (j = i + 1; j < arr.length; j++) {
                        if (arr[i].length() > arr[j].length()) {
                            tmp = arr[i];
                            arr[i] = arr[j];
                            arr[j] = tmp;
                        }
                    }
                }
                break;
            case 2:
                for (i = 0; i < arr.length; i++) {
                    for (j = i + 1; j < arr.length; j++) {
                        if (arr[i].compareTo(arr[j]) > 0) {
                            tmp = arr[i];
                            arr[i] = arr[j];
                            arr[j] = tmp;
                        }
                    }
                }
                break;
        }
    }

    public Iterator<String> iterator() {
        return new Iterator<String>() {
            private int index = 0;

            @Override
            public boolean hasNext() {
                return index < size() && arr[index] != null;
            }

            @Override
            public String next() {
                return arr[index++];
            }

            @Override
            public void remove() {
                Container.this.remove(arr[index]);
            }
        };
    }
}