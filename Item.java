public class Item {
    private String name;
    private String description;
    private Chave key;

    public Item(String name) {
        this.name = name;
        description = "";
    }

    public Item(String name, String description) {
        this.name = name;
        this.description = description;
    }

    public String getName() {
        if (key!= null){
            return KeyFormatter.keyFormat(key);
        }
        return name;
    }

    public String getDescription() {
        return description;
    }

    public void setKey(Chave key) {
        this.key = key;
    }
    public boolean hasKey (){
        return key != null;
    }

    public Chave getKey() {
        return key;
    }

    public void removeKey() {
        key = null;
    }
}
