package com.calculator.possiblelandroutecalculator.client;

import com.calculator.possiblelandroutecalculator.model.Country;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.client.RestClientTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.client.MockRestServiceServer;
import org.springframework.test.web.client.response.MockRestResponseCreators;


import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.springframework.test.web.client.match.MockRestRequestMatchers.requestTo;

@RestClientTest({CountryClient.class})
class CountryClientImplTest {

    @Autowired
    private MockRestServiceServer mockRestServiceServer;

    @Autowired
    private CountryClient countryClient;

    @DisplayName("Should Return A List Contains All Countries")
    @Test
    void shouldReturnCountryList(){

        String url = "https://raw.githubusercontent.com/mledoze/countries/master/countries.json";
        mockRestServiceServer.expect(requestTo(url))
                .andRespond(MockRestResponseCreators.withSuccess(getExpectedCountryJson(), MediaType.APPLICATION_JSON));

        List<Country> actualCountryList = countryClient.getCountryList();


        assertAll(
                () -> assertEquals(4, actualCountryList.size()),
                () -> assertEquals("ABW", actualCountryList.get(0).getCca3()),
                () -> assertEquals("AFG", actualCountryList.get(1).getCca3()),
                () -> assertEquals("AGO", actualCountryList.get(2).getCca3()),
                () -> assertEquals("AIA", actualCountryList.get(3).getCca3())
        );


    }

    public String getExpectedCountryJson(){
        return "[\n" +
                "    {\n" +
                "        \"name\": {\n" +
                "            \"common\": \"Aruba\",\n" +
                "            \"official\": \"Aruba\",\n" +
                "            \"native\": {\n" +
                "                \"nld\": {\n" +
                "                    \"official\": \"Aruba\",\n" +
                "                    \"common\": \"Aruba\"\n" +
                "                },\n" +
                "                \"pap\": {\n" +
                "                    \"official\": \"Aruba\",\n" +
                "                    \"common\": \"Aruba\"\n" +
                "                }\n" +
                "            }\n" +
                "        },\n" +
                "        \"tld\": [\n" +
                "            \".aw\"\n" +
                "        ],\n" +
                "        \"cca2\": \"AW\",\n" +
                "        \"ccn3\": \"533\",\n" +
                "        \"cca3\": \"ABW\",\n" +
                "        \"cioc\": \"ARU\",\n" +
                "        \"independent\": false,\n" +
                "        \"status\": \"officially-assigned\",\n" +
                "        \"unMember\": false,\n" +
                "        \"currencies\": {\n" +
                "            \"AWG\": {\n" +
                "                \"name\": \"Aruban florin\",\n" +
                "                \"symbol\": \"\\u0192\"\n" +
                "            }\n" +
                "        },\n" +
                "        \"idd\": {\n" +
                "            \"root\": \"+2\",\n" +
                "            \"suffixes\": [\n" +
                "                \"97\"\n" +
                "            ]\n" +
                "        },\n" +
                "        \"capital\": [\n" +
                "            \"Oranjestad\"\n" +
                "        ],\n" +
                "        \"altSpellings\": [\n" +
                "            \"AW\"\n" +
                "        ],\n" +
                "        \"region\": \"Americas\",\n" +
                "        \"subregion\": \"Caribbean\",\n" +
                "        \"languages\": {\n" +
                "            \"nld\": \"Dutch\",\n" +
                "            \"pap\": \"Papiamento\"\n" +
                "        },\n" +
                "        \"translations\": {\n" +
                "            \"ces\": {\n" +
                "                \"official\": \"Aruba\",\n" +
                "                \"common\": \"Aruba\"\n" +
                "            },\n" +
                "            \"deu\": {\n" +
                "                \"official\": \"Aruba\",\n" +
                "                \"common\": \"Aruba\"\n" +
                "            },\n" +
                "            \"est\": {\n" +
                "                \"official\": \"Aruba\",\n" +
                "                \"common\": \"Aruba\"\n" +
                "            },\n" +
                "            \"fin\": {\n" +
                "                \"official\": \"Aruba\",\n" +
                "                \"common\": \"Aruba\"\n" +
                "            },\n" +
                "            \"fra\": {\n" +
                "                \"official\": \"Aruba\",\n" +
                "                \"common\": \"Aruba\"\n" +
                "            },\n" +
                "            \"hrv\": {\n" +
                "                \"official\": \"Aruba\",\n" +
                "                \"common\": \"Aruba\"\n" +
                "            },\n" +
                "            \"hun\": {\n" +
                "                \"official\": \"Aruba\",\n" +
                "                \"common\": \"Aruba\"\n" +
                "            },\n" +
                "            \"ita\": {\n" +
                "                \"official\": \"Aruba\",\n" +
                "                \"common\": \"Aruba\"\n" +
                "            },\n" +
                "            \"jpn\": {\n" +
                "                \"official\": \"\\u30a2\\u30eb\\u30d0\",\n" +
                "                \"common\": \"\\u30a2\\u30eb\\u30d0\"\n" +
                "            },\n" +
                "            \"kor\": {\n" +
                "                \"official\": \"\\uc544\\ub8e8\\ubc14\",\n" +
                "                \"common\": \"\\uc544\\ub8e8\\ubc14\"\n" +
                "            },\n" +
                "            \"nld\": {\n" +
                "                \"official\": \"Aruba\",\n" +
                "                \"common\": \"Aruba\"\n" +
                "            },\n" +
                "            \"per\": {\n" +
                "                \"official\": \"\\u0622\\u0631\\u0648\\u0628\\u0627\",\n" +
                "                \"common\": \"\\u0622\\u0631\\u0648\\u0628\\u0627\"\n" +
                "            },\n" +
                "            \"pol\": {\n" +
                "                \"official\": \"Aruba\",\n" +
                "                \"common\": \"Aruba\"\n" +
                "            },\n" +
                "            \"por\": {\n" +
                "                \"official\": \"Aruba\",\n" +
                "                \"common\": \"Aruba\"\n" +
                "            },\n" +
                "            \"rus\": {\n" +
                "                \"official\": \"\\u0410\\u0440\\u0443\\u0431\\u0430\",\n" +
                "                \"common\": \"\\u0410\\u0440\\u0443\\u0431\\u0430\"\n" +
                "            },\n" +
                "            \"slk\": {\n" +
                "                \"official\": \"Aruba\",\n" +
                "                \"common\": \"Aruba\"\n" +
                "            },\n" +
                "            \"spa\": {\n" +
                "                \"official\": \"Aruba\",\n" +
                "                \"common\": \"Aruba\"\n" +
                "            },\n" +
                "            \"swe\": {\n" +
                "                \"official\": \"Aruba\",\n" +
                "                \"common\": \"Aruba\"\n" +
                "            },\n" +
                "            \"urd\": {\n" +
                "                \"official\": \"\\u0627\\u0631\\u0648\\u0628\\u0627\",\n" +
                "                \"common\": \"\\u0627\\u0631\\u0648\\u0628\\u0627\"\n" +
                "            },\n" +
                "            \"zho\": {\n" +
                "                \"official\": \"\\u963f\\u9c81\\u5df4\",\n" +
                "                \"common\": \"\\u963f\\u9c81\\u5df4\"\n" +
                "            }\n" +
                "        },\n" +
                "        \"latlng\": [\n" +
                "            12.5,\n" +
                "            -69.96666666\n" +
                "        ],\n" +
                "        \"landlocked\": false,\n" +
                "        \"borders\": [],\n" +
                "        \"area\": 180,\n" +
                "        \"flag\": \"\\ud83c\\udde6\\ud83c\\uddfc\",\n" +
                "        \"demonyms\": {\n" +
                "            \"eng\": {\n" +
                "                \"f\": \"Aruban\",\n" +
                "                \"m\": \"Aruban\"\n" +
                "            },\n" +
                "            \"fra\": {\n" +
                "                \"f\": \"Arubaise\",\n" +
                "                \"m\": \"Arubais\"\n" +
                "            }\n" +
                "        }\n" +
                "    },\n" +
                "    {\n" +
                "        \"name\": {\n" +
                "            \"common\": \"Afghanistan\",\n" +
                "            \"official\": \"Islamic Republic of Afghanistan\",\n" +
                "            \"native\": {\n" +
                "                \"prs\": {\n" +
                "                    \"official\": \"\\u062c\\u0645\\u0647\\u0648\\u0631\\u06cc \\u0627\\u0633\\u0644\\u0627\\u0645\\u06cc \\u0627\\u0641\\u063a\\u0627\\u0646\\u0633\\u062a\\u0627\\u0646\",\n" +
                "                    \"common\": \"\\u0627\\u0641\\u063a\\u0627\\u0646\\u0633\\u062a\\u0627\\u0646\"\n" +
                "                },\n" +
                "                \"pus\": {\n" +
                "                    \"official\": \"\\u062f \\u0627\\u0641\\u063a\\u0627\\u0646\\u0633\\u062a\\u0627\\u0646 \\u0627\\u0633\\u0644\\u0627\\u0645\\u064a \\u062c\\u0645\\u0647\\u0648\\u0631\\u06cc\\u062a\",\n" +
                "                    \"common\": \"\\u0627\\u0641\\u063a\\u0627\\u0646\\u0633\\u062a\\u0627\\u0646\"\n" +
                "                },\n" +
                "                \"tuk\": {\n" +
                "                    \"official\": \"Owganystan Yslam Respublikasy\",\n" +
                "                    \"common\": \"Owganystan\"\n" +
                "                }\n" +
                "            }\n" +
                "        },\n" +
                "        \"tld\": [\n" +
                "            \".af\"\n" +
                "        ],\n" +
                "        \"cca2\": \"AF\",\n" +
                "        \"ccn3\": \"004\",\n" +
                "        \"cca3\": \"AFG\",\n" +
                "        \"cioc\": \"AFG\",\n" +
                "        \"independent\": true,\n" +
                "        \"status\": \"officially-assigned\",\n" +
                "        \"unMember\": true,\n" +
                "        \"currencies\": {\n" +
                "            \"AFN\": {\n" +
                "                \"name\": \"Afghan afghani\",\n" +
                "                \"symbol\": \"\\u060b\"\n" +
                "            }\n" +
                "        },\n" +
                "        \"idd\": {\n" +
                "            \"root\": \"+9\",\n" +
                "            \"suffixes\": [\n" +
                "                \"3\"\n" +
                "            ]\n" +
                "        },\n" +
                "        \"capital\": [\n" +
                "            \"Kabul\"\n" +
                "        ],\n" +
                "        \"altSpellings\": [\n" +
                "            \"AF\",\n" +
                "            \"Af\\u0121\\u0101nist\\u0101n\"\n" +
                "        ],\n" +
                "        \"region\": \"Asia\",\n" +
                "        \"subregion\": \"Southern Asia\",\n" +
                "        \"languages\": {\n" +
                "            \"prs\": \"Dari\",\n" +
                "            \"pus\": \"Pashto\",\n" +
                "            \"tuk\": \"Turkmen\"\n" +
                "        },\n" +
                "        \"translations\": {\n" +
                "            \"ces\": {\n" +
                "                \"official\": \"Afgh\\u00e1nsk\\u00e1 isl\\u00e1msk\\u00e1 republika\",\n" +
                "                \"common\": \"Afgh\\u00e1nist\\u00e1n\"\n" +
                "            },\n" +
                "            \"cym\": {\n" +
                "                \"official\": \"Gweriniaeth Islamaidd Affganistan\",\n" +
                "                \"common\": \"Affganistan\"\n" +
                "            },\n" +
                "            \"deu\": {\n" +
                "                \"official\": \"Islamische Republik Afghanistan\",\n" +
                "                \"common\": \"Afghanistan\"\n" +
                "            },\n" +
                "            \"est\": {\n" +
                "                \"official\": \"Afganistani Islamivabariik\",\n" +
                "                \"common\": \"Afganistan\"\n" +
                "            },\n" +
                "            \"fin\": {\n" +
                "                \"official\": \"Afganistanin islamilainen tasavalta\",\n" +
                "                \"common\": \"Afganistan\"\n" +
                "            },\n" +
                "            \"fra\": {\n" +
                "                \"official\": \"R\\u00e9publique islamique d'Afghanistan\",\n" +
                "                \"common\": \"Afghanistan\"\n" +
                "            },\n" +
                "            \"hrv\": {\n" +
                "                \"official\": \"Islamska Republika Afganistan\",\n" +
                "                \"common\": \"Afganistan\"\n" +
                "            },\n" +
                "            \"hun\": {\n" +
                "                \"official\": \"Afganiszt\\u00e1ni Iszl\\u00e1m K\\u00f6zt\\u00e1rsas\\u00e1g\",\n" +
                "                \"common\": \"Afganiszt\\u00e1n\"\n" +
                "            },\n" +
                "            \"ita\": {\n" +
                "                \"official\": \"Repubblica islamica dell'Afghanistan\",\n" +
                "                \"common\": \"Afghanistan\"\n" +
                "            },\n" +
                "            \"jpn\": {\n" +
                "                \"official\": \"\\u30a2\\u30d5\\u30ac\\u30cb\\u30b9\\u30bf\\u30f3\\u00b7\\u30a4\\u30b9\\u30e9\\u30e0\\u5171\\u548c\\u56fd\",\n" +
                "                \"common\": \"\\u30a2\\u30d5\\u30ac\\u30cb\\u30b9\\u30bf\\u30f3\"\n" +
                "            },\n" +
                "            \"kor\": {\n" +
                "                \"official\": \"\\uc544\\ud504\\uac00\\ub2c8\\uc2a4\\ud0c4 \\uc774\\uc2ac\\ub78c \\uacf5\\ud654\\uad6d\",\n" +
                "                \"common\": \"\\uc544\\ud504\\uac00\\ub2c8\\uc2a4\\ud0c4\"\n" +
                "            },\n" +
                "            \"nld\": {\n" +
                "                \"official\": \"Islamitische Republiek Afghanistan\",\n" +
                "                \"common\": \"Afghanistan\"\n" +
                "            },\n" +
                "            \"per\": {\n" +
                "                \"official\": \"\\u062c\\u0645\\u0647\\u0648\\u0631\\u06cc \\u0627\\u0633\\u0644\\u0627\\u0645\\u06cc \\u0627\\u0641\\u063a\\u0627\\u0646\\u0633\\u062a\\u0627\\u0646\",\n" +
                "                \"common\": \"\\u0627\\u0641\\u063a\\u0627\\u0646\\u0633\\u062a\\u0627\\u0646\"\n" +
                "            },\n" +
                "            \"pol\": {\n" +
                "                \"official\": \"Islamska Republika Afganistanu\",\n" +
                "                \"common\": \"Afganistan\"\n" +
                "            },\n" +
                "            \"por\": {\n" +
                "                \"official\": \"Rep\\u00fablica Isl\\u00e2mica do Afeganist\\u00e3o\",\n" +
                "                \"common\": \"Afeganist\\u00e3o\"\n" +
                "            },\n" +
                "            \"rus\": {\n" +
                "                \"official\": \"\\u0418\\u0441\\u043b\\u0430\\u043c\\u0441\\u043a\\u0430\\u044f \\u0420\\u0435\\u0441\\u043f\\u0443\\u0431\\u043b\\u0438\\u043a\\u0430 \\u0410\\u0444\\u0433\\u0430\\u043d\\u0438\\u0441\\u0442\\u0430\\u043d\",\n" +
                "                \"common\": \"\\u0410\\u0444\\u0433\\u0430\\u043d\\u0438\\u0441\\u0442\\u0430\\u043d\"\n" +
                "            },\n" +
                "            \"slk\": {\n" +
                "                \"official\": \"Afg\\u00e1nsky islamsk\\u00fd \\u0161t\\u00e1t\",\n" +
                "                \"common\": \"Afganistan\"\n" +
                "            },\n" +
                "            \"spa\": {\n" +
                "                \"official\": \"Rep\\u00fablica Isl\\u00e1mica de Afganist\\u00e1n\",\n" +
                "                \"common\": \"Afganist\\u00e1n\"\n" +
                "            },\n" +
                "            \"swe\": {\n" +
                "                \"official\": \"Islamiska republiken Afghanistan\",\n" +
                "                \"common\": \"Afghanistan\"\n" +
                "            },\n" +
                "            \"urd\": {\n" +
                "                \"official\": \"\\u0627\\u0633\\u0644\\u0627\\u0645\\u06cc \\u062c\\u0645\\u06c1\\u0648\\u0631\\u06cc\\u06c1 \\u0627\\u0641\\u063a\\u0627\\u0646\\u0633\\u062a\\u0627\\u0646\",\n" +
                "                \"common\": \"\\u0627\\u0641\\u063a\\u0627\\u0646\\u0633\\u062a\\u0627\\u0646\"\n" +
                "            },\n" +
                "            \"zho\": {\n" +
                "                \"official\": \"\\u963f\\u5bcc\\u6c57\\u4f0a\\u65af\\u5170\\u5171\\u548c\\u56fd\",\n" +
                "                \"common\": \"\\u963f\\u5bcc\\u6c57\"\n" +
                "            }\n" +
                "        },\n" +
                "        \"latlng\": [\n" +
                "            33,\n" +
                "            65\n" +
                "        ],\n" +
                "        \"landlocked\": true,\n" +
                "        \"borders\": [\n" +
                "            \"IRN\",\n" +
                "            \"PAK\",\n" +
                "            \"TKM\",\n" +
                "            \"UZB\",\n" +
                "            \"TJK\",\n" +
                "            \"CHN\"\n" +
                "        ],\n" +
                "        \"area\": 652230,\n" +
                "        \"flag\": \"\\ud83c\\udde6\\ud83c\\uddeb\",\n" +
                "        \"demonyms\": {\n" +
                "            \"eng\": {\n" +
                "                \"f\": \"Afghan\",\n" +
                "                \"m\": \"Afghan\"\n" +
                "            },\n" +
                "            \"fra\": {\n" +
                "                \"f\": \"Afghane\",\n" +
                "                \"m\": \"Afghan\"\n" +
                "            }\n" +
                "        }\n" +
                "    },\n" +
                "    {\n" +
                "        \"name\": {\n" +
                "            \"common\": \"Angola\",\n" +
                "            \"official\": \"Republic of Angola\",\n" +
                "            \"native\": {\n" +
                "                \"por\": {\n" +
                "                    \"official\": \"Rep\\u00fablica de Angola\",\n" +
                "                    \"common\": \"Angola\"\n" +
                "                }\n" +
                "            }\n" +
                "        },\n" +
                "        \"tld\": [\n" +
                "            \".ao\"\n" +
                "        ],\n" +
                "        \"cca2\": \"AO\",\n" +
                "        \"ccn3\": \"024\",\n" +
                "        \"cca3\": \"AGO\",\n" +
                "        \"cioc\": \"ANG\",\n" +
                "        \"independent\": true,\n" +
                "        \"status\": \"officially-assigned\",\n" +
                "        \"unMember\": true,\n" +
                "        \"currencies\": {\n" +
                "            \"AOA\": {\n" +
                "                \"name\": \"Angolan kwanza\",\n" +
                "                \"symbol\": \"Kz\"\n" +
                "            }\n" +
                "        },\n" +
                "        \"idd\": {\n" +
                "            \"root\": \"+2\",\n" +
                "            \"suffixes\": [\n" +
                "                \"44\"\n" +
                "            ]\n" +
                "        },\n" +
                "        \"capital\": [\n" +
                "            \"Luanda\"\n" +
                "        ],\n" +
                "        \"altSpellings\": [\n" +
                "            \"AO\",\n" +
                "            \"Rep\\u00fablica de Angola\",\n" +
                "            \"\\u0281\\u025bpublika de an'\\u0261\\u0254la\"\n" +
                "        ],\n" +
                "        \"region\": \"Africa\",\n" +
                "        \"subregion\": \"Middle Africa\",\n" +
                "        \"languages\": {\n" +
                "            \"por\": \"Portuguese\"\n" +
                "        },\n" +
                "        \"translations\": {\n" +
                "            \"ces\": {\n" +
                "                \"official\": \"Angolsk\\u00e1 republika\",\n" +
                "                \"common\": \"Angola\"\n" +
                "            },\n" +
                "            \"cym\": {\n" +
                "                \"official\": \"Gweriniaeth Angola\",\n" +
                "                \"common\": \"Angola\"\n" +
                "            },\n" +
                "            \"deu\": {\n" +
                "                \"official\": \"Republik Angola\",\n" +
                "                \"common\": \"Angola\"\n" +
                "            },\n" +
                "            \"est\": {\n" +
                "                \"official\": \"Angola Vabariik\",\n" +
                "                \"common\": \"Angola\"\n" +
                "            },\n" +
                "            \"fin\": {\n" +
                "                \"official\": \"Angolan tasavalta\",\n" +
                "                \"common\": \"Angola\"\n" +
                "            },\n" +
                "            \"fra\": {\n" +
                "                \"official\": \"R\\u00e9publique d'Angola\",\n" +
                "                \"common\": \"Angola\"\n" +
                "            },\n" +
                "            \"hrv\": {\n" +
                "                \"official\": \"Republika Angola\",\n" +
                "                \"common\": \"Angola\"\n" +
                "            },\n" +
                "            \"hun\": {\n" +
                "                \"official\": \"Angola\",\n" +
                "                \"common\": \"Angola\"\n" +
                "            },\n" +
                "            \"ita\": {\n" +
                "                \"official\": \"Repubblica dell'Angola\",\n" +
                "                \"common\": \"Angola\"\n" +
                "            },\n" +
                "            \"jpn\": {\n" +
                "                \"official\": \"\\u30a2\\u30f3\\u30b4\\u30e9\\u5171\\u548c\\u56fd\",\n" +
                "                \"common\": \"\\u30a2\\u30f3\\u30b4\\u30e9\"\n" +
                "            },\n" +
                "            \"kor\": {\n" +
                "                \"official\": \"\\uc559\\uace8\\ub77c \\uacf5\\ud654\\uad6d\",\n" +
                "                \"common\": \"\\uc559\\uace8\\ub77c\"\n" +
                "            },\n" +
                "            \"nld\": {\n" +
                "                \"official\": \"Republiek Angola\",\n" +
                "                \"common\": \"Angola\"\n" +
                "            },\n" +
                "            \"per\": {\n" +
                "                \"official\": \"\\u062c\\u0645\\u0647\\u0648\\u0631\\u06cc \\u0622\\u0646\\u06af\\u0648\\u0644\\u0627\",\n" +
                "                \"common\": \"\\u0622\\u0646\\u06af\\u0648\\u0644\\u0627\"\n" +
                "            },\n" +
                "            \"pol\": {\n" +
                "                \"official\": \"Republika Angoli\",\n" +
                "                \"common\": \"Angola\"\n" +
                "            },\n" +
                "            \"por\": {\n" +
                "                \"official\": \"Rep\\u00fablica de Angola\",\n" +
                "                \"common\": \"Angola\"\n" +
                "            },\n" +
                "            \"rus\": {\n" +
                "                \"official\": \"\\u0420\\u0435\\u0441\\u043f\\u0443\\u0431\\u043b\\u0438\\u043a\\u0430 \\u0410\\u043d\\u0433\\u043e\\u043b\\u0430\",\n" +
                "                \"common\": \"\\u0410\\u043d\\u0433\\u043e\\u043b\\u0430\"\n" +
                "            },\n" +
                "            \"slk\": {\n" +
                "                \"official\": \"Angolsk\\u00e1 republika\",\n" +
                "                \"common\": \"Angola\"\n" +
                "            },\n" +
                "            \"spa\": {\n" +
                "                \"official\": \"Rep\\u00fablica de Angola\",\n" +
                "                \"common\": \"Angola\"\n" +
                "            },\n" +
                "            \"swe\": {\n" +
                "                \"official\": \"Republiken Angola\",\n" +
                "                \"common\": \"Angola\"\n" +
                "            },\n" +
                "            \"urd\": {\n" +
                "                \"official\": \"\\u062c\\u0645\\u06c1\\u0648\\u0631\\u06cc\\u06c1 \\u0627\\u0646\\u06af\\u0648\\u0644\\u06c1\",\n" +
                "                \"common\": \"\\u0627\\u0646\\u06af\\u0648\\u0644\\u06c1\"\n" +
                "            },\n" +
                "            \"zho\": {\n" +
                "                \"official\": \"\\u5b89\\u54e5\\u62c9\\u5171\\u548c\\u56fd\",\n" +
                "                \"common\": \"\\u5b89\\u54e5\\u62c9\"\n" +
                "            }\n" +
                "        },\n" +
                "        \"latlng\": [\n" +
                "            -12.5,\n" +
                "            18.5\n" +
                "        ],\n" +
                "        \"landlocked\": false,\n" +
                "        \"borders\": [\n" +
                "            \"COG\",\n" +
                "            \"COD\",\n" +
                "            \"ZMB\",\n" +
                "            \"NAM\"\n" +
                "        ],\n" +
                "        \"area\": 1246700,\n" +
                "        \"flag\": \"\\ud83c\\udde6\\ud83c\\uddf4\",\n" +
                "        \"demonyms\": {\n" +
                "            \"eng\": {\n" +
                "                \"f\": \"Angolan\",\n" +
                "                \"m\": \"Angolan\"\n" +
                "            },\n" +
                "            \"fra\": {\n" +
                "                \"f\": \"Angolaise\",\n" +
                "                \"m\": \"Angolais\"\n" +
                "            }\n" +
                "        }\n" +
                "    },\n" +
                "    {\n" +
                "        \"name\": {\n" +
                "            \"common\": \"Anguilla\",\n" +
                "            \"official\": \"Anguilla\",\n" +
                "            \"native\": {\n" +
                "                \"eng\": {\n" +
                "                    \"official\": \"Anguilla\",\n" +
                "                    \"common\": \"Anguilla\"\n" +
                "                }\n" +
                "            }\n" +
                "        },\n" +
                "        \"tld\": [\n" +
                "            \".ai\"\n" +
                "        ],\n" +
                "        \"cca2\": \"AI\",\n" +
                "        \"ccn3\": \"660\",\n" +
                "        \"cca3\": \"AIA\",\n" +
                "        \"cioc\": \"\",\n" +
                "        \"independent\": false,\n" +
                "        \"status\": \"officially-assigned\",\n" +
                "        \"unMember\": false,\n" +
                "        \"currencies\": {\n" +
                "            \"XCD\": {\n" +
                "                \"name\": \"Eastern Caribbean dollar\",\n" +
                "                \"symbol\": \"$\"\n" +
                "            }\n" +
                "        },\n" +
                "        \"idd\": {\n" +
                "            \"root\": \"+1\",\n" +
                "            \"suffixes\": [\n" +
                "                \"264\"\n" +
                "            ]\n" +
                "        },\n" +
                "        \"capital\": [\n" +
                "            \"The Valley\"\n" +
                "        ],\n" +
                "        \"altSpellings\": [\n" +
                "            \"AI\"\n" +
                "        ],\n" +
                "        \"region\": \"Americas\",\n" +
                "        \"subregion\": \"Caribbean\",\n" +
                "        \"languages\": {\n" +
                "            \"eng\": \"English\"\n" +
                "        },\n" +
                "        \"translations\": {\n" +
                "            \"ces\": {\n" +
                "                \"official\": \"Anguilla\",\n" +
                "                \"common\": \"Anguilla\"\n" +
                "            },\n" +
                "            \"deu\": {\n" +
                "                \"official\": \"Anguilla\",\n" +
                "                \"common\": \"Anguilla\"\n" +
                "            },\n" +
                "            \"est\": {\n" +
                "                \"official\": \"Anguilla\",\n" +
                "                \"common\": \"Anguilla\"\n" +
                "            },\n" +
                "            \"fin\": {\n" +
                "                \"official\": \"Anguilla\",\n" +
                "                \"common\": \"Anguilla\"\n" +
                "            },\n" +
                "            \"fra\": {\n" +
                "                \"official\": \"Anguilla\",\n" +
                "                \"common\": \"Anguilla\"\n" +
                "            },\n" +
                "            \"hrv\": {\n" +
                "                \"official\": \"Anguilla\",\n" +
                "                \"common\": \"Angvila\"\n" +
                "            },\n" +
                "            \"hun\": {\n" +
                "                \"official\": \"Anguilla\",\n" +
                "                \"common\": \"Anguilla\"\n" +
                "            },\n" +
                "            \"ita\": {\n" +
                "                \"official\": \"Anguilla\",\n" +
                "                \"common\": \"Anguilla\"\n" +
                "            },\n" +
                "            \"jpn\": {\n" +
                "                \"official\": \"\\u30a2\\u30f3\\u30b0\\u30a3\\u30e9\",\n" +
                "                \"common\": \"\\u30a2\\u30f3\\u30ae\\u30e9\"\n" +
                "            },\n" +
                "            \"kor\": {\n" +
                "                \"official\": \"\\uc575\\uadc8\\ub77c\",\n" +
                "                \"common\": \"\\uc575\\uadc8\\ub77c\"\n" +
                "            },\n" +
                "            \"nld\": {\n" +
                "                \"official\": \"Anguilla\",\n" +
                "                \"common\": \"Anguilla\"\n" +
                "            },\n" +
                "            \"per\": {\n" +
                "                \"official\": \"\\u0622\\u0646\\u06af\\u0648\\u06cc\\u0644\\u0627\",\n" +
                "                \"common\": \"\\u0622\\u0646\\u06af\\u0648\\u06cc\\u0644\\u0627\"\n" +
                "            },\n" +
                "            \"pol\": {\n" +
                "                \"official\": \"Anguilla\",\n" +
                "                \"common\": \"Anguilla\"\n" +
                "            },\n" +
                "            \"por\": {\n" +
                "                \"official\": \"Anguilla\",\n" +
                "                \"common\": \"Anguilla\"\n" +
                "            },\n" +
                "            \"rus\": {\n" +
                "                \"official\": \"\\u0410\\u043d\\u0433\\u0438\\u043b\\u044c\\u044f\",\n" +
                "                \"common\": \"\\u0410\\u043d\\u0433\\u0438\\u043b\\u044c\\u044f\"\n" +
                "            },\n" +
                "            \"slk\": {\n" +
                "                \"official\": \"Anguilla\",\n" +
                "                \"common\": \"Anguilla\"\n" +
                "            },\n" +
                "            \"spa\": {\n" +
                "                \"official\": \"Anguila\",\n" +
                "                \"common\": \"Anguilla\"\n" +
                "            },\n" +
                "            \"swe\": {\n" +
                "                \"official\": \"Anguilla\",\n" +
                "                \"common\": \"Anguilla\"\n" +
                "            },\n" +
                "            \"urd\": {\n" +
                "                \"official\": \"\\u0627\\u06cc\\u0646\\u06af\\u0648\\u06cc\\u0644\\u0627\",\n" +
                "                \"common\": \"\\u0627\\u06cc\\u0646\\u06af\\u0648\\u06cc\\u0644\\u0627\"\n" +
                "            },\n" +
                "            \"zho\": {\n" +
                "                \"official\": \"\\u5b89\\u572d\\u62c9\",\n" +
                "                \"common\": \"\\u5b89\\u572d\\u62c9\"\n" +
                "            }\n" +
                "        },\n" +
                "        \"latlng\": [\n" +
                "            18.25,\n" +
                "            -63.16666666\n" +
                "        ],\n" +
                "        \"landlocked\": false,\n" +
                "        \"borders\": [],\n" +
                "        \"area\": 91,\n" +
                "        \"flag\": \"\\ud83c\\udde6\\ud83c\\uddee\",\n" +
                "        \"demonyms\": {\n" +
                "            \"eng\": {\n" +
                "                \"f\": \"Anguillian\",\n" +
                "                \"m\": \"Anguillian\"\n" +
                "            },\n" +
                "            \"fra\": {\n" +
                "                \"f\": \"Anguillane\",\n" +
                "                \"m\": \"Anguillan\"\n" +
                "            }\n" +
                "        }\n" +
                "    }]";
    }

}