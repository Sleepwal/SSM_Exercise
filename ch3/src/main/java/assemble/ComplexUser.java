package assemble;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class ComplexUser {
    private String username;
    private List<String> hobbyList;
    private Map<String, String> residenceMap;
    private Set<String> aliasSet;
    private String[] array;

    public ComplexUser() {
    }

    public ComplexUser(String username, List<String> hobbyList, Map<String, String> residenceMap, Set<String> aliasSet, String[] array) {
        this.username = username;
        this.hobbyList = hobbyList;
        this.residenceMap = residenceMap;
        this.aliasSet = aliasSet;
        this.array = array;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public void setHobbyList(List<String> hobbyList) {
        this.hobbyList = hobbyList;
    }

    public void setResidenceMap(Map<String, String> residenceMap) {
        this.residenceMap = residenceMap;
    }

    public void setAliasSet(Set<String> aliasSet) {
        this.aliasSet = aliasSet;
    }

    public void setArray(String[] array) {
        this.array = array;
    }

    @Override
    public String toString() {
        return "ComplexUser{" +
                "username='" + username + '\'' +
                ", hobbyList=" + hobbyList +
                ", residenceMap=" + residenceMap +
                ", aliasSet=" + aliasSet +
                ", array=" + Arrays.toString(array) +
                '}';
    }
}
