package model.application;

import model.entities.VoteCandidates;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;

public class Program {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        Map<VoteCandidates, Integer> candidatesVotes = new LinkedHashMap<>();

        System.out.print("Enter file full path: ");
        String filePath = input.nextLine();
        File file = new File(filePath);

        try (BufferedReader br = new BufferedReader(new FileReader(file))) {
            String line;
            while ((line = br.readLine()) != null) {
                String[]fields = line.split(",");
                String candidateName = fields[0];
                Integer votes = Integer.parseInt(fields[1]);
                VoteCandidates candidate = new VoteCandidates(candidateName, votes);
                if (candidatesVotes.containsKey(candidate)) {
                    candidatesVotes.put(candidate, candidatesVotes.get(candidate) + votes);
                } else {
                    candidatesVotes.put(candidate, votes);
                }
            }
            for(VoteCandidates key : candidatesVotes.keySet()){
                System.out.println(key + ": " + candidatesVotes.get(key));
            }

        } catch (IOException e) {
            System.out.println("Error opening file" + e.getMessage() );
        }
        input.close();
    }
}
