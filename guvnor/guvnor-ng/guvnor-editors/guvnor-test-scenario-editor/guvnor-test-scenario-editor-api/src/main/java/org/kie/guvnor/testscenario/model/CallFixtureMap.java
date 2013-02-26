package org.kie.guvnor.testscenario.model;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;


public class CallFixtureMap
        implements Fixture, Map<String, FixtureList> {

    private HashMap<String, FixtureList> map = new HashMap<String, FixtureList>();

    @Override
    public int size() {
        return map.size();
    }

    @Override
    public boolean isEmpty() {
        return map.isEmpty();
    }

    @Override
    public boolean containsKey(Object o) {
        return map.containsKey(o);
    }

    @Override
    public boolean containsValue(Object o) {
        return map.containsValue(o);
    }

    @Override
    public FixtureList get(Object o) {
        return map.get(o);
    }

    @Override
    public FixtureList put(String s, FixtureList fixtures) {
        return map.put(s, fixtures);
    }

    @Override
    public FixtureList remove(Object o) {
        return map.remove(o);
    }

    @Override
    public void putAll(Map<? extends String, ? extends FixtureList> map) {
        for (String key : map.keySet()) {
            this.map.put(key, map.get(key));
        }
    }

    @Override
    public void clear() {
        map.clear();
    }

    @Override
    public Set<String> keySet() {
        return map.keySet();
    }

    @Override
    public Collection<FixtureList> values() {
        return map.values();
    }

    @Override
    public Set<Entry<String, FixtureList>> entrySet() {
        return map.entrySet();
    }
}
