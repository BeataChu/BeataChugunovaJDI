package homework7.entities;


import com.epam.jdi.tools.DataClass;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class Substances extends DataClass<Substances> {
    private List<Integer> summary;
    private List<String> elements;
    private String color;
    private String metals;
    private List<String> vegetables;

}
