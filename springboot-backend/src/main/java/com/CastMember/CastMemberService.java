package com.CastMember;

import com.Exception.ResourceNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/***
 * @author Connor Hunter        connh321@gmail.com
 *
 * A CastMember service responsible for business logic and making calls so the data accessing repository and returning the
 * proper data.
 *
 */
@Service
public class CastMemberService {
    @Autowired // Injected Singleton
    private final CastMemberRepository castMemberRepository;

    //Constructor
    public CastMemberService(CastMemberRepository castMemberRepository) {
        this.castMemberRepository = castMemberRepository;
    }

    /**
     * Gets all castMembers from the database
     *
     * @return A list of all castMembers
     */
    public List<CastMemberModel> getAllCastMembers() {
        return castMemberRepository.findAll(); // returns a list of castMembers
    }


    /**
     * Saves a new castMember into the repository
     *
     * @param castMember A given castMember
     * @return a newly saved CastMember
     */
    public CastMemberModel createCastMember(CastMemberModel castMember) {
        return castMemberRepository.save(castMember);
    }


    /**
     * Gets a castMember by cmid and returns it
     *
     * @param cmid A given cmid
     * @return A castMember, or an RNF Exception
     */
    public CastMemberModel getCastMemberById(Long cmid) {
        return castMemberRepository.findById(cmid)
                .orElseThrow(() -> new ResourceNotFoundException("CastMember With the cmid: " + cmid + " does not exist!"));
    }


    /**
     * Updates a given castMember by cmid given some new details
     *
     * @param cmid    A long cmid
     * @param castMemberDetails A castMember details
     * @return A castMember, or an RNF exception
     */
    public CastMemberModel updateCastMember(Long cmid, CastMemberModel castMemberDetails) {
        CastMemberModel castMember = castMemberRepository.findById(cmid)
                .orElseThrow(() -> new ResourceNotFoundException("CastMember With the cmid: " + cmid + " does not exist!"));

        castMember.setFirstName(castMemberDetails.getFirstName());
        castMember.setLastName(castMemberDetails.getLastName());


        return castMemberRepository.save(castMember);
    }


    /**
     * Deletes a castMember given a cmid
     *
     * @param cmid A long cmid
     */
    public void deleteCastMember(Long cmid) {
        CastMemberModel castMember = castMemberRepository.findById(cmid)
                .orElseThrow(() -> new ResourceNotFoundException("CastMember With the cmid: " + cmid + " does not exist!"));
        castMemberRepository.delete(castMember);
    }

}
