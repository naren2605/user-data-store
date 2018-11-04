package test.fission.service;

import java.util.List;

public interface EntityObjectConverter<Source,Target> {

    public Target toTarget(Source source);
    public List<Target> toTarget(List<Source> sources);
}
