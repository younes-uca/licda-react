package  ma.sir.vaccination.ws.facade.admin;


import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import ma.sir.vaccination.bean.core.Dose;
import ma.sir.vaccination.bean.history.DoseHistory;
import ma.sir.vaccination.dao.criteria.core.DoseCriteria;
import ma.sir.vaccination.dao.criteria.history.DoseHistoryCriteria;
import ma.sir.vaccination.service.facade.admin.DoseAdminService;
import ma.sir.vaccination.ws.converter.DoseConverter;
import ma.sir.vaccination.ws.dto.DoseDto;
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

@Api("Manages dose services")
@RestController
@RequestMapping("/api/admin/dose/")
public class DoseRestAdmin  extends AbstractController<Dose, DoseDto, DoseHistory, DoseCriteria, DoseHistoryCriteria, DoseAdminService, DoseConverter> {



    @ApiOperation("Exporte pdf")
    @PostMapping("exportPdf/")
    public HttpEntity<byte[]> createPdf(@RequestBody DoseDto dto) throws Exception{
        return service.createPdf(dto);
    }
    @ApiOperation("upload one dose")
    @RequestMapping(value = "upload", method = RequestMethod.POST, consumes = "multipart/form-data")
    public ResponseEntity<FileTempDto> uploadFileAndGetChecksum(@RequestBody MultipartFile file) throws Exception {
        return super.uploadFileAndGetChecksum(file);
    }
    @ApiOperation("upload multiple doses")
    @RequestMapping(value = "upload-multiple", method = RequestMethod.POST, consumes = "multipart/form-data")
    public ResponseEntity<List<FileTempDto>> uploadMultipleFileAndGetChecksum(@RequestBody MultipartFile[] files) throws Exception {
        return super.uploadMultipleFileAndGetChecksum(files);
    }

    @ApiOperation("Finds a list of all doses")
    @GetMapping("")
    public ResponseEntity<List<DoseDto>> findAll() throws Exception {
        return super.findAll();
    }


    @ApiOperation("Finds a dose by id")
    @GetMapping("id/{id}")
    public ResponseEntity<DoseDto> findById(@PathVariable Long id, String[] includes, String[] excludes) throws Exception {
        return super.findById(id, includes, excludes);
    }
    @ApiOperation("Saves the specified  dose")
    @PostMapping("")
    public ResponseEntity<DoseDto> save(@RequestBody DoseDto dto) throws Exception {
        return super.save(dto);
    }

    @ApiOperation("Updates the specified  dose")
    @PutMapping("")
    public ResponseEntity<DoseDto> update(@RequestBody DoseDto dto) throws Exception {
        return super.update(dto);
    }

    @ApiOperation("Delete list of dose")
    @PostMapping("multiple")
    public ResponseEntity<List<DoseDto>> delete(@RequestBody List<DoseDto> listToDelete) throws Exception {
        return super.delete(listToDelete);
    }
    @ApiOperation("Delete the specified dose")
    @DeleteMapping("")
    public ResponseEntity<DoseDto> delete(@RequestBody DoseDto dto) throws Exception {
            return super.delete(dto);
    }

    @ApiOperation("Delete the specified dose")
    @DeleteMapping("id/{id}")
    public ResponseEntity<Long> deleteById(@PathVariable Long id) throws Exception {
        return super.deleteById(id);
    }
    @ApiOperation("Delete multiple doses by ids")
    @DeleteMapping("multiple/id")
    public ResponseEntity<List<Long>> deleteByIdIn(@RequestBody List<Long> ids) throws Exception {
            return super.deleteByIdIn(ids);
     }


    @ApiOperation("find by rendezVous id")
    @GetMapping("rendezVous/id/{id}")
    public List<Dose> findByRendezVousId(@PathVariable Long id){
        return service.findByRendezVousId(id);
    }
    @ApiOperation("delete by rendezVous id")
    @DeleteMapping("rendezVous/id/{id}")
    public int deleteByRendezVousId(@PathVariable Long id){
        return service.deleteByRendezVousId(id);
    }
    @ApiOperation("find by etatDose id")
    @GetMapping("etatDose/id/{id}")
    public List<Dose> findByEtatDoseId(@PathVariable Long id){
        return service.findByEtatDoseId(id);
    }
    @ApiOperation("delete by etatDose id")
    @DeleteMapping("etatDose/id/{id}")
    public int deleteByEtatDoseId(@PathVariable Long id){
        return service.deleteByEtatDoseId(id);
    }
    @ApiOperation("Finds doses by criteria")
    @PostMapping("find-by-criteria")
    public ResponseEntity<List<DoseDto>> findByCriteria(@RequestBody DoseCriteria criteria) throws Exception {
        return super.findByCriteria(criteria);
    }

    @ApiOperation("Finds paginated doses by criteria")
    @PostMapping("find-paginated-by-criteria")
    public ResponseEntity<PaginatedList> findPaginatedByCriteria(@RequestBody DoseCriteria criteria) throws Exception {
        return super.findPaginatedByCriteria(criteria);
    }

    @ApiOperation("Exports doses by criteria")
    @PostMapping("export")
    public ResponseEntity<InputStreamResource> export(@RequestBody DoseCriteria criteria) throws Exception {
        return super.export(criteria);
    }

    @ApiOperation("Gets dose data size by criteria")
    @PostMapping("data-size-by-criteria")
    public ResponseEntity<Integer> getDataSize(@RequestBody DoseCriteria criteria) throws Exception {
        return super.getDataSize(criteria);
    }

    @ApiOperation("Gets dose history by id")
    @GetMapping("history/id/{id}")
    public ResponseEntity<AuditEntityDto> findHistoryById(@PathVariable("id") Long id) throws Exception {
        return super.findHistoryById(id);
    }

    @ApiOperation("Gets dose paginated history by criteria")
    @PostMapping("history-paginated-by-criteria")
    public ResponseEntity<PaginatedList> findHistoryPaginatedByCriteria(@RequestBody DoseHistoryCriteria criteria) throws Exception {
        return super.findHistoryPaginatedByCriteria(criteria);
    }

    @ApiOperation("Exports dose history by criteria")
    @PostMapping("export-history")
    public ResponseEntity<InputStreamResource> exportHistory(@RequestBody DoseHistoryCriteria criteria) throws Exception {
        return super.exportHistory(criteria);
    }

    @ApiOperation("Gets dose history data size by criteria")
    @PostMapping("history-data-size")
    public ResponseEntity<Integer> getHistoryDataSize(@RequestBody DoseHistoryCriteria criteria) throws Exception {
        return super.getHistoryDataSize(criteria);
    }
    public DoseRestAdmin (DoseAdminService service, DoseConverter converter) {
        super(service, converter);
    }


}