package parikalan.xenium.dataValues;

import android.content.Context;
import android.content.SharedPreferences;
import android.util.Log;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

import parikalan.xenium.R;

public class Information {

    public String ename, etype, edesc, erules, edate = "11th March'15", etime, evenue, enote, eh1, eh2, epno1, epno2;
    public int sno, iconId, emin, emax;

    Information(int eid, String ename, String etype, String edesc, String erules, String etime, String evenue, String enote, String eh1, String eh2, String epno1, String epno2, int emin, int emax) {
        this.iconId = eid;
        this.ename = ename;
        this.etype = etype;
        this.edesc = edesc;
        this.erules = erules;
        this.etime = etime;
        this.evenue = evenue;
        this.enote = enote;
        this.eh1 = eh1;
        this.eh2 = eh2;
        this.epno1 = epno1;
        this.epno2 = epno2;
        this.emin = emin;
        this.emax = emax;

    }

    public static List<Information> getData(Context c) throws JSONException {
        List<Information> data = new ArrayList<>();
        Information current;

        current = new Information(R.drawable.rsz_event_codesense,
                "Code-Sense",
                "",
                "Are you lazy enough to read long programs? Do you find shortcuts in every task? Are you a die-hard programmer? Did I hear a “YES”? Then, you can win prizes for these qualities. If you think yourself to be the engineer of this generation, come here and compete in CODE-Sense.. Your CODE will decide it BETTER..!!",
                "1. Participation will be in teams of two.\n" +
                        "2. There will be 2 Rounds first round will be MCQ + Subjective paper. 40 questions will be given to each team and 20 mins will be given to answer all questions.\n" +
                        "3. Result will be compiled by event head only and will be finalized by coordinating teacher.\n" +
                        "4. Any discussions on answers of MCQ round will not be entertained.\n" +
                        "5. 5-7 teams will go to round 2 depending on the number of participating teams, prizes and any kind of tie situation among teams.\n" +
                        "6. Round 2 will be of 45 mins, 2 Questions will be given to each team each question will carry equal marks.\n" +
                        "7. Marks will be given to each team on the basis of their programming efficiency, logics and skills.\n" +
                        "8. For round 2 result will be compiled by entire coding team and will be finalized by coordinating teacher.\n" +
                        "9. If found with cell phones or any electronic devices within your possession in the entire coding competition your team will be disqualified.\n" +
                        "10. Programming will only be done on Turbo C in C/C++ language any request for a different compiler will be denied.\n" +
                        "11. Entire Competition will be based on C/C++ language and general computer science knowledge.",
                "10:30 am",
                "CS Lab 12",
                "",
                "Ishan Rathi",
                "Himanshu Kakkar",
                "9015124835",
                "8447664219",
                2, 2
        );
        data.add(current);

        current = new Information(R.drawable.rsz_event_hacktrack,
                "HackTrack",
                "",
                "So you call yourself a hacker, its time to prove yourself! Xenium presents the biggest hacking challenge that you've ever face. HackTrack - The Hacking Event.",
                "1. Participation will be individual.\n" +
                        "2. There will be 2 Rounds first round will be MCQ. 10 questions will be asked to every participant. Answer as much as you can.\n" +
                        "3. Result will be compiled by event head only and will be finalized by coordinating teacher.\n" +
                        "4. Any discussions on answers of MCQ round will not be entertained.\n" +
                        "5. 8-12 participant will reach to the next round and rest depends on the number of participant.\n" +
                        "6. Round 2 will be of 50 mins.\n" +
                        "7. A Wi-Fi router will be there around you which may be of the WEP/WPA/WPA2 security. Everyone have to attack on that router for getting the access to the router." +
                        "8. Once the participant have got the access to the router, then they need to connect to the router.\n" +
                        "9. After connecting to the router, you have to scan the network devices connected to that router.\n" +
                        "10. you will get three devices on the wi‐fi network. you need to attack on one of them to get the access.\n" +
                        "11. Once you have got the access, then you need to create a file on the desktop of the target computer named with your name. There you go, Now you are one and only Hacker of HackTrack.\n" +
                        "12. Marks will be given to each participant on the basis of their methods, they have choosen during the hacking. like what kind tools they have used and all.\n" +
                        "13. For round 2 result will be compiled by entire HackTrack team and will be finalized by coordinatinator teacher.\n" +
                        "14. Participants have to bring their own laptop/notebook and charging adapter as well.\n" +
                        "15. Participant can use external wi‐fi adapters as well for making the wi‐fi cracking process faster.",
                "11:00 am",
                "CS Lab 11",
                "",
                "Parvinder Yadav",
                "Navneet Singh",
                "8287730229",
                "9560420979",
                1, 1
        );
        data.add(current);


        current = new Information(R.drawable.rsz_event_extempore,
                "Xtempore",
                "",
                "Flex your nerves, and prepare your words to impress our judges! Shoot words, hit the mark and win cash-prizes. Be precise, because you'll only get 1 min.",
                "1. This is a single participation event.\n" +
                        "2. The event is bilingual, i.e participants can either speak in English or in hindi. But not combine the two.\n" +
                        "3. Use of un-parliamentary words is strictly prohibited.\n" +
                        "4. Decision of the judges is final and binding.\n" +
                        "5. Participants cannot use smart phones or any other such gadgets.\n" +
                        "6. ROUNDS\n" +
                        "Round 1- Participants would be given a topic and then get 30 seconds to think after which they would have to speak for 1 minute\n" +
                        "Round 2- Participants would be given a topic and would get 45 seconds to think after which they would have to speak for 2 minutes.",
                "11:00 am",
                "Seminar Hall",
                "",
                "Arfat",
                "Nishant Banik",
                "7428197541",
                "9873753273",
                1, 1
        );
        data.add(current);

        current = new Information(R.drawable.rsz_event_isomania,
                "Insomnia",
                "LAN War",
                "Bom dia gamers! Come feel the adrenaline rush as it goes big and down to the wire! May it be a Rabona or a simple Elastico. Can you do what it takes to grab the winner.",
                "1. The Half-Life Counter-Strike PC game championship 5x5 (team play, 5 members per team).\n" +
                        "2. The Tournament Organizers reserves the right to cancel or modify the tournament rules.\n" +
                        "3. Tournament game rules\n" +
                        "* The tournament is divided into three categories\n" +
                        "\tKnockout- 6 Rounds (4 to win)\n" +
                        "\tSemifinal- 20 Rounds (11 to win)\n" +
                        "\tFinal- 30 Rounds (16 to win)\n" +
                        "* A knife-round is used to decide which team plays Counter-Terrorist and which team plays Terrorist.\n" +
                        "* In the incident of a tie, One more round will be played with teams to be intact e.g. with 15-15 score, the team that wins next round will win with 4-3(knockout),11-10(semifinals),16-15(finals).\n" +
                        "4. Official tournament maps: \n" +
                        "   * de_dust2 \n" +
                        "   * de_inferno \n" +
                        "   * de_nuke\n" +
                        "   * de_train\n" +
                        "5. Teams has to mail there CFGs at mevishaljangid@gmail.com before 12:00 am on 11 March, CFG File will not be accepted at the time of tournament\n" +
                        "6. Team and Team in-game leader name must be written on the CFG file Folder and the subject of the mail should be \"CFG File\".\n" +
                        "7. In case you don't know about cfg file don't send it, its not necessary, it is just to save time in setting up.\n" +
                        "8. Tactical shield and Auto Sniper use is forbidden.\n" +
                        "9. The Head of the event has the right to disqualify and dismiss any registered player from the tournament.\n" +
                        "10. The Head's decisions are final.",
                "11:00 am",
                "CS Lab 112",
                "Registrations on the day of the competition will close after 20 teams have arrived.\n" +
                        "Entry Fee: ₹ 200/- per team (5 Members)",
                "Vishal Sharma",
                "Kapil Saini",
                "7529941378",
                "8376026286",
                5, 5
        );
        data.add(current);


        current = new Information(R.drawable.rsz_event_consolegaming,
                "Insomnia",
                "Console Gaming",
                "Bom dia gamers! Come feel the adrenaline rush as it goes big and down to the wire! May it be a Rabona or a simple Elastico. Can you do what it takes to grab the winner.",
                "The event would be conducted on play station 4 platform and the game being FIFA 16. The rules for the event are as follows - \n" +
                        "1. The event would be conducted in a knockout format.\n" +
                        "2. Half length - 4 minutes till semi-finals and 6 minutes in semis and finals\n" +
                        "3. Use of legacy defending and all star teams (classic 11) is not allowed\n" +
                        "4. No custom tactics to be used\n" +
                        "5. In case of a draw, the result to be determined by penalties till the semis. Extra time to be given only in the finals.\n" +
                        "6. Participants are advised to bring their own controllers if possible\n" +
                        "7. In case of any dispute the coordinators to have the final say.\n" +
                        "8. Participants will be given 2 minutes to manage their teams and check controls\n",
                "11:00 am",
                "Room",
                "Entry fee - 50 INR",
                "Sarthak Dawar",
                "Himanshu Verma",
                "8447477221",
                "9211319197",
                1, 1
        );
        data.add(current);

        current = new Information(R.drawable.rsz_event_spec_obfuscation,
                "Spec Obfuscation",
                "Quiz with Virtual Bidding",
                "You think you have it in you? The brain of computer genius. Vision of an entrepreneur. Then embrace your geekiness and perseverance, because its time for Quiz with a Virtual Bidding Twist.",
                "1. Only team entries are eligible.\n" +
                        "2. A team shall consist of only two persons\n" +
                        "3. The decision of the judges will be final and will not be subjected to any change. \n" +
                        "4. The participants shall not be allowed to  use mobile or other electronic instruments.\n" +
                        "5. The questions shall be in the form of multiple choice, True/False statement, Specific-answer question etc.\n" +
                        "6. Audience  shall  not give any hints or clues to the competitors.\n" +
                        "7. Replacement of any participant  of a team is not allowed after registration\n" +
                        "Elimination Round\n" +
                        "1. Each team would be given a set of question papers containing objective type questions/fill in the blanks type.\n" +
                        "2. Time limit – 15-20 minutes.\n" +
                        "3. Only 6-10 Teams would be selected for furthur bidding ROUNDS.\n" +
                        "4. In case of tie between 2 or more teams, temas will be judged on few specific questions.\n" +
                        "Money in the Bank Rounds \n" +
                        "\tThis round will be a crossword round. Based on the performance of teams in this round they will be allocated sufficient virtual cash for bidding in upcoming round\n" +
                        "Round 3 - VIRTUAL BIDDING (Max 10 teams)\n" +
                        "Teams bid for the specs they want in their smart phones. The team with the most complete and best smart phone wins.\n" +
                        "Judging Criteria – the criteria is in order of preference\n" +
                        "  - Completeness of the smart phone (if it has everything that a phone needs)\n" +
                        "  - Better specs\n" +
                        "  - Compatibility\n" +
                        "  - Money saved",
                "12:15 pm",
                "Seminar Hall",
                "",
                "Talal Ansari",
                "Shivam Ahuja",
                "8510861678",
                "8860842049",
                2, 2
        );
        data.add(current);

        current = new Information(R.drawable.rsz_event_scrounge,
                "Scrounge",
                "Technical Treasure Hunt",
                "Caption jack sparrow Billy bones and caption hook have been trying to find the hidden treasure and here is your chance to outrun them in this quest. So find your pirates crew ready your ship and venture out into the vast ocean called PGDAV. Be the first to unearth the precious treasure.",
                "1. The Treasure Hunt consists of fifteen clues, each one leading to clue.\n" +
                        "2.Each team has to announce a leader at the time of registration.\n" +
                        "3. All decisions will be final and binding and will be decided by the organising committee (team).\n" +
                        "4. Every participant should carry their respective valid college ID’s failing to which participation will not be allowed.\n" +
                        "5. Violation of any rules, prompting, inappropriate behaviour or damaging any college property will lead to the direct disqualification.\n" +
                        "6. Teams will have to perform physical task in the event.\n" +
                        "7. Splitting of team members are not allowed if the event is organised only in college premises else splitting will be allowed.",
                "2:15 pm",
                "Main Stage",
                "Entry fee - 50 INR",
                "Himanshu Sharma",
                "Vinay Kumar",
                "8802762731",
                "9013375252",
                2, 2
        );
        data.add(current);

        current = new Information(R.drawable.rsz_event_directorscut,
                "Anime",
                "Directors Cut",
                "For those who capture moment of now, as they will be memories tomorrow. Revive the world, Capture the untouched. Mesmerize it. Show your world to us. Xenium's directors cut offers them the ultimate opportunity to showcase their talent.",
                "1. Only Registered participants are allowed . you can register yourself on the spot on 11th March.\n" +
                        "2. Use of Smartphones and Camera are allowed.\n" +
                        "3. Duration of the clip should not exceed 60 secs.\n" +
                        "4. A team can have maximum of 2 participants.\n" +
                        "5. You'll have to make a short movie on the ongoing events at Xenium 16.0.",
                "Whole Event",
                "College",
                "",
                "Saif Haider",
                "Vijayant Kumar",
                "9717620127",
                "8527532587",
                2, 2
        );
        data.add(current);

        current = new Information(R.drawable.rsz_event_etambola,
                "E-Tambola",
                "",
                "Its been so long while playing with numbers and flirting with your luck. The wits of a numerologist and intuition of a seer is all what it takes ...get smarter this time. Try E-tambola.",
                "1. The Tambola ticket contains alphanumeric characters and the clue will be in the form of questions with 1-character answer.\n" +
                        "2. Only individual participation is allowed.\n" +
                        "3. Winners will be chosen on the basis of fastest and correct answers on the chits.\n" +
                        "4. Other rules are as per standard game of Tambola.\n" +
                        "5. Any use of unfair means or misconduct/misbehavior with the volunteers will lead to immediate disqualification.\n" +
                        "6. Players who first obtain any or all of the following win:-\n" +
                        "      a. Early Five\n" +
                        "      b. Four corners\n" +
                        "      c. Three rows\n" +
                        "      d. Full House",
                "Whole Day",
                "Main Stage",
                "Entry fee - 20 INR",
                "Kumar Kshitij",
                "Shubham Agarwal",
                "8826587339",
                "9990810087",
                1, 1
        );
        data.add(current);

        current = new Information(R.drawable.rsz_event_techcharades,
                "Tech Charades",
                "",
                "Technical dumb‐charades is a new and exciting version of dumb‐charades in which the team has to enact the given technical term.",
                "1. The team should constitute of 3 members.\n" +
                        "2. Lip movement is not allowed ‐ only hand movements should be there.\n" +
                        "3. No alphabets are to be indicated.\n" +
                        "4. No objects should be indicated.\n" +
                        "4. Total of 3 rounds are there.\n" +
                        "5. Each member have to act in atleast one round and the other two would guess the technical term.\n" +
                        "7. In the 3rd Round , the person acting would have to answer the given question to get the technical term.\n" +
                        "8. Time limit of 60 seconds in every round.",
                "Whole Day",
                "Main Stage",
                "Entry fee - 30 INR",
                "Mayur",
                "Kanika Manocha",
                "9711757870",
                "9582196906",
                3, 3
        );
        data.add(current);

        current = new Information(R.drawable.rsz_adfortech,
                "AD-MAD",
                "",
                "AD for TECH is an 'Advertisement Making Competition' for all students to showcase their creativity. It comprises of humorous & conceptual ad presentation by the students. Students will have to act out on various advertisement script or products like laptops etc. All the teams will be given a time frame to showcase their talent.",
                "1. A team comprises of 2 members. \n" +
                        "2. Contestant have to show their ad within the given time limit.\n" +
                        "3. The ad prepared by the contestant must not contain any obscene wor  ds/any subject that hurts the feelings of a culture/language/religion/region.\n" +
                        "4. Negative marking for any disobedience of rules.\n" +
                        "5. The teams will be judged on following criterion—\n" +
                        "-> Advertisement’s content – How humorous it is.\n" +
                        "-> Expressions\n" +
                        "-> The presenter’s fluency\n" +
                        "6. The decision of the judge is final and abiding.",
                "Whole Day",
                "Main Stage",
                "Entry fee - 30 INR",
                "Nidhi Bhoj",
                "Naresh Kumar",
                "8527215127",
                "9654356550",
                4, 4
        );
        data.add(current);

        current = new Information(R.drawable.rsz_event_robowars,
                "Robo Wars",
                "",
                "All Spark is discovered again, Get ready with your Auto-Bots or Decepticons. We will guide, you will find, Lets see who's got the perfect mind and Bot to compete.",
                "Hurdle Trek:\n" +
                        "1. A team will consist of only two players.\n" +
                        "2. The robot will be yours we will not be providing robot.\n" +
                        "3. We will be providing arena only to compete.\n" +
                        "4. There is no restriction on the micro-controller provided you have done the coding yourself.\n" +
                        "5. Robot with wireless controller will be beneficial for you, otherwise you will have to handle the wired robot yourself.\n" +
                        "6. No hardware or software support will be provided to you regarding your robot functioning.\n" +
                        "7. The hurdles will consist of hurdles like curly pathways, uphills and downhills, rocky path, muddy path, path with water too etc.\n" +
                        "8. The winning will depend on your controlling and deductive skills. \n" +
                        "9. The participants are requested not to assume anything without discussing with the event coordinators.\n" +
                        "10. Decisions of the coordinators are final.\n" +
                        "11. Coordinators hold the right to change the rules and guidelines without prior notification.\n\n" +
                        "Criteria for selection:\n" +
                        "Complete the task in the least time and making least mistakes from start to finish.\n\n" +
                        "Marking Scheme:\n" +
                        "1. Time will be recorded from start to finish.\n" +
                        "2. Wrong or extra turn (+5 sec)\n" +
                        "3. Manually putting your robot on last covered legal checkpoint (+7 sec each time).\n" +
                        "4. Braking any other rule will cost +2 sec penalty.",
                "Whole Day",
                "Main Stage",
                "",
                "Kashish Singh",
                "Deepanshu Rastogi",
                "9711583643",
                "8527839363",
                2, 2
        );
        data.add(current);

        try {
            SharedPreferences spd = c.getSharedPreferences("Xenium16", c.MODE_PRIVATE);
            String jayson = spd.getString("jayson", "");
            if (jayson.length() > 1) {
                JSONObject reader = new JSONObject(jayson);
                JSONArray opn = reader.getJSONArray("operation");
                for (int i = 0; i < opn.length(); i++) {
                    JSONObject o = opn.getJSONObject(i);
                    if (o.optString("type").equals("update")) {
                        Information k = data.get(o.optInt("eventno"));
                        switch (o.optString("var")) {
                            case "rules":
                                k.erules = o.getString("value");
                                break;
                            case "ename":
                                k.ename = o.getString("value");
                                break;
                            case "venue":
                                k.evenue = o.getString("value");
                                break;
                            case "time":
                                k.etime = o.getString("value");
                                break;
                            case "date":
                                k.edate = o.getString("value");
                                break;
                            case "desc":
                                k.edesc = o.getString("value");
                                break;
                            case "type":
                                k.etype = o.getString("value");
                                break;
                            case "note":
                                k.enote = o.getString("value");
                                break;
                            case "min":
                                k.emin = o.getInt("value");
                                break;
                            case "max":
                                k.emax = o.getInt("value");
                                break;
                        }
                    }
                }
            }
        } catch (JSONException e) {
            Log.e("json", e.getMessage() + "");
        }

        return data;
    }

    public static String getTimeonly(String name, Context c) throws JSONException {
        List<Information> data = getData(c);
        for (int i = 0; i < data.size(); i++) {
            if (data.get(i).ename.equals(name)) {
                return data.get(i).etime;
            }
        }
        return "TBA";
    }

    public static String getvenueonly(String name, Context c) throws JSONException {
        List<Information> data = getData(c);
        for (int i = 0; i < data.size(); i++) {
            if (data.get(i).ename.equals(name)) {
                return data.get(i).evenue;
            }
        }
        return "TBA";
    }

}
