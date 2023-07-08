package  ma.sir.vaccination.ws.facade.admin;


import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import ma.sir.vaccination.bean.core.RendezVous;
import ma.sir.vaccination.bean.history.RendezVousHistory;
import ma.sir.vaccination.dao.criteria.core.RendezVousCriteria;
import ma.sir.vaccination.dao.criteria.history.RendezVousHistoryCriteria;
import ma.sir.vaccination.service.facade.admin.RendezVousAdminService;
import ma.sir.vaccination.ws.converter.RendezVousConverter;
import ma.sir.vaccination.ws.dto.RendezVousDto;
import ma.sir.vaccination.zynerator.controller.AbstractController;
import ma.sir.vaccination.zynerator.dto.AuditEntityDto;
import ma.sir.vaccination.zynerator.util.PaginatedList;
import org.springframework.core.io.InputStreamResource;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import ma.sir.vaccination.zynerator.process.Result;

import org.springframework.http.HttpEntity;

import org.springframework.web.multipart.MultipartFile;
import ma.sir.vaccination.zynerator.dto.FileTempDto;

@Api("Manages rendezVous services")
@RestController
@RequestMapping("/api/admin/rendezVous/")
public class RendezVousRestAdmin  extends AbstractController<RendezVous, RendezVousDto, RendezVousHistory, RendezVousCriteria, RendezVousHistoryCriteria, RendezVousAdminService, RendezVousConverter> {



    @ApiOperation("Exporte pdf")
    @PostMapping("exportPdf/")
    public HttpEntity<byte[]> createPdf(@RequestBody RendezVousDto dto) throws Exception{
        return service.createPdf(dto);
    }
    @ApiOperation("upload one rendezVous")
    @RequestMapping(value = "upload", method = RequestMethod.POST, consumes = "multipart/form-data")
    public ResponseEntity<FileTempDto> uploadFileAndGetChecksum(@RequestBody MultipartFile file) throws Exception {
        return super.uploadFileAndGetChecksum(file);
    }
    @ApiOperation("upload multiple rendezVouss")
    @RequestMapping(value = "upload-multiple", method = RequestMethod.POST, consumes = "multipart/form-data")
    public ResponseEntity<List<FileTempDto>> uploadMultipleFileAndGetChecksum(@RequestBody MultipartFile[] files) throws Exception {
        return super.uploadMultipleFileAndGetChecksum(files);
    }

    @ApiOperation("Finds a list of all rendezVouss")
    @GetMapping("")
    public ResponseEntity<List<RendezVousDto>> findAll() throws Exception {
        return super.findAll();
    }


    @ApiOperation("Finds a rendezVous by id")
    @GetMapping("id/{id}")
    public ResponseEntity<RendezVousDto> findById(@PathVariable Long id, String[] includes, String[] excludes) throws Exception {
        return super.findById(id, includes, excludes);
    }
    @ApiOperation("Saves the specified  rendezVous")
    @PostMapping("")
    public ResponseEntity<RendezVousDto> save(@RequestBody RendezVousDto dto) throws Exception {
        return super.save(dto);
    }

    @ApiOperation("Updates the specified  rendezVous")
    @PutMapping("")
    public ResponseEntity<RendezVousDto> update(@RequestBody RendezVousDto dto) throws Exception {
        return super.update(dto);
    }

    @ApiOperation("Delete list of rendezVous")
    @PostMapping("multiple")
    public ResponseEntity<List<RendezVousDto>> delete(@RequestBody List<RendezVousDto> listToDelete) throws Exception {
        return super.delete(listToDelete);
    }
    @ApiOperation("Delete the specified rendezVous")
    @DeleteMapping("")
    public ResponseEntity<RendezVousDto> delete(@RequestBody RendezVousDto dto) throws Exception {
            return super.delete(dto);
    }

    @ApiOperation("Delete the specified rendezVous")
    @DeleteMapping("id/{id}")
    public ResponseEntity<Long> deleteById(@PathVariable Long id) throws Exception {
        return super.deleteById(id);
    }
    @ApiOperation("Delete multiple rendezVouss by ids")
    @DeleteMapping("multiple/id")
    public ResponseEntity<List<Long>> deleteByIdIn(@RequestBody List<Long> ids) throws Exception {
            return super.deleteByIdIn(ids);
     }


    @ApiOperation("find by patient id")
    @GetMapping("patient/id/{id}")
    public List<RendezVous> findByPatientId(@PathVariable Long id){
        return service.findByPatientId(id);
    }
    @ApiOperation("delete by patient id")
    @DeleteMapping("patient/id/{id}")
    public int deleteByPatientId(@PathVariable Long id){
        return service.deleteByPatientId(id);
    }
    @ApiOperation("find by center id")
    @GetMapping("center/id/{id}")
    public List<RendezVous> findByCenterId(@PathVariable Long id){
        return service.findByCenterId(id);
    }
    @ApiOperation("delete by center id")
    @DeleteMapping("center/id/{id}")
    public int deleteByCenterId(@PathVariable Long id){
        return service.deleteByCenterId(id);
    }
    @ApiOperation("find by medecin id")
    @GetMapping("medecin/id/{id}")
    public List<RendezVous> findByMedecinId(@PathVariable Long id){
        return service.findByMedecinId(id);
    }
    @ApiOperation("delete by medecin id")
    @DeleteMapping("medecin/id/{id}")
    public int deleteByMedecinId(@PathVariable Long id){
        return service.deleteByMedecinId(id);
    }
    @ApiOperation("find by categorieRdv id")
    @GetMapping("categorieRdv/id/{id}")
    public List<RendezVous> findByCategorieRdvId(@PathVariable Long id){
        return service.findByCategorieRdvId(id);
    }
    @ApiOperation("delete by categorieRdv id")
    @DeleteMapping("categorieRdv/id/{id}")
    public int deleteByCategorieRdvId(@PathVariable Long id){
        return service.deleteByCategorieRdvId(id);
    }
    @ApiOperation("find by etatRendezVous id")
    @GetMapping("etatRendezVous/id/{id}")
    public List<RendezVous> findByEtatRendezVousId(@PathVariable Long id){
        return service.findByEtatRendezVousId(id);
    }
    @ApiOperation("delete by etatRendezVous id")
    @DeleteMapping("etatRendezVous/id/{id}")
    public int deleteByEtatRendezVousId(@PathVariable Long id){
        return service.deleteByEtatRendezVousId(id);
    }
    @ApiOperation("Finds a rendezVous and associated list by id")
    @GetMapping("detail/id/{id}")
    public ResponseEntity<RendezVousDto> findWithAssociatedLists(@PathVariable Long id) {
        return super.findWithAssociatedLists(id);
    }

    @ApiOperation("Finds rendezVouss by criteria")
    @PostMapping("find-by-criteria")
    public ResponseEntity<List<RendezVousDto>> findByCriteria(@RequestBody RendezVousCriteria criteria) throws Exception {
        return super.findByCriteria(criteria);
    }

    @ApiOperation("Finds paginated rendezVouss by criteria")
    @PostMapping("find-paginated-by-criteria")
    public ResponseEntity<PaginatedList> findPaginatedByCriteria(@RequestBody RendezVousCriteria criteria) throws Exception {
        return super.findPaginatedByCriteria(criteria);
    }

    @ApiOperation("Exports rendezVouss by criteria")
    @PostMapping("export")
    public ResponseEntity<InputStreamResource> export(@RequestBody RendezVousCriteria criteria) throws Exception {
        return super.export(criteria);
    }

    @ApiOperation("Gets rendezVous data size by criteria")
    @PostMapping("data-size-by-criteria")
    public ResponseEntity<Integer> getDataSize(@RequestBody RendezVousCriteria criteria) throws Exception {
        return super.getDataSize(criteria);
    }

    @ApiOperation("Gets rendezVous history by id")
    @GetMapping("history/id/{id}")
    public ResponseEntity<AuditEntityDto> findHistoryById(@PathVariable("id") Long id) throws Exception {
        return super.findHistoryById(id);
    }

    @ApiOperation("Gets rendezVous paginated history by criteria")
    @PostMapping("history-paginated-by-criteria")
    public ResponseEntity<PaginatedList> findHistoryPaginatedByCriteria(@RequestBody RendezVousHistoryCriteria criteria) throws Exception {
        return super.findHistoryPaginatedByCriteria(criteria);
    }

    @ApiOperation("Exports rendezVous history by criteria")
    @PostMapping("export-history")
    public ResponseEntity<InputStreamResource> exportHistory(@RequestBody RendezVousHistoryCriteria criteria) throws Exception {
        return super.exportHistory(criteria);
    }

    @ApiOperation("Gets rendezVous history data size by criteria")
    @PostMapping("history-data-size")
    public ResponseEntity<Integer> getHistoryDataSize(@RequestBody RendezVousHistoryCriteria criteria) throws Exception {
        return super.getHistoryDataSize(criteria);
    }
    public RendezVousRestAdmin (RendezVousAdminService service, RendezVousConverter converter) {
        super(service, converter);
    }


}