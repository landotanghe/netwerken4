/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package woordenboek.impl;

import com.aonaware.services.webservices.ArrayOfDefinition;
import com.aonaware.services.webservices.ArrayOfDictionary;
import com.aonaware.services.webservices.ArrayOfDictionaryWord;
import com.aonaware.services.webservices.Definition;
import com.aonaware.services.webservices.Dictionary;
import com.aonaware.services.webservices.DictionaryWord;
import com.aonaware.services.webservices.WordDefinition;
import java.util.ArrayList;
import java.util.List;
import woordenboek.data.Woordenboek;
import woordenboek.data.WoordenboekDAO;

/**
 *
 * @author Lando Tanghe
 */
public class WoordenBoekDAOReal implements WoordenboekDAO {

    @Override
    public List<Woordenboek> getWoordenboeken() {
        List<Dictionary> dictionaries = dictionaryList().getDictionary();
        List<Woordenboek> woordenboeken = new ArrayList<>();
        for (Dictionary dict : dictionaries) {
            woordenboeken.add(new Woordenboek(dict.getId(), dict.getName()));
        }
        return woordenboeken;
    }

    @Override
    public List<String> zoekWoorden(String prefix, String woordenboekId) {
        List<DictionaryWord> words = matchInDict(woordenboekId, prefix, "prefix").getDictionaryWord();
        List<String> woorden = new ArrayList<>();
        for (DictionaryWord word : words) {
            woorden.add(word.getWord());
        }
        return woorden;
    }

    @Override
    public List<String> getDefinities(String woord, String woordenboekId) {
        List<Definition> definitions = defineInDict(woordenboekId, woord).getDefinitions().getDefinition();
        List<String> definities = new ArrayList<>();
        for (Definition def : definitions) {
            definities.add(def.getWordDefinition());
        }
        return definities;
    }

    private static ArrayOfDictionary dictionaryList() {
        com.aonaware.services.webservices.DictService service = new com.aonaware.services.webservices.DictService();
        com.aonaware.services.webservices.DictServiceSoap port = service.getDictServiceSoap();
        return port.dictionaryList();
    }

    private static ArrayOfDictionaryWord matchInDict(java.lang.String dictId, java.lang.String word, java.lang.String strategy) {
        com.aonaware.services.webservices.DictService service = new com.aonaware.services.webservices.DictService();
        com.aonaware.services.webservices.DictServiceSoap port = service.getDictServiceSoap();
        return port.matchInDict(dictId, word, strategy);
    }

    private static WordDefinition defineInDict(java.lang.String dictId, java.lang.String word) {
        com.aonaware.services.webservices.DictService service = new com.aonaware.services.webservices.DictService();
        com.aonaware.services.webservices.DictServiceSoap port = service.getDictServiceSoap();
        return port.defineInDict(dictId, word);
    }

}
