package homework7.entities;


import com.epam.jdi.tools.DataClass;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class Substances extends DataClass<Substances> {
    private String colors;
    private List<String> elements;
    private String metals;
    private List<Integer> summary;
    private List<String> vegetables;

}
