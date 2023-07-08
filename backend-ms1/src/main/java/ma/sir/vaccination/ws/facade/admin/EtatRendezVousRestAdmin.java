package  ma.sir.vaccination.ws.facade.admin;


import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import ma.sir.vaccination.bean.core.EtatRendezVous;
import ma.sir.vaccination.bean.history.EtatRendezVousHistory;
import ma.sir.vaccination.dao.criteria.core.EtatRendezVousCriteria;
import ma.sir.vaccination.dao.criteria.history.EtatRendezVousHistoryCriteria;
import ma.sir.vaccination.service.facade.admin.EtatRendezVousAdminService;
import ma.sir.vaccination.ws.converter.EtatRendezVousConverter;
import ma.sir.vaccination.ws.dto.EtatRendezVousDto;
import ma.sir.vaccination.zynerator.controller.AbstractController;
import ma.sir.vaccination.zynerator.dto.AuditEntityDto;
import ma.sir.vaccination.zynerator.util.PaginatedList;
import org.springframework.core.io.InputStreamResource;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import ma.sir.vaccination.zynerator.process.Result;


import org.springframework.web.multipart.MultipartFile;
import ma.sir.vaccination.zynerator.dto.FileTempDto;

@Api("Manages etatRendezVous services")
@RestController
@RequestMapping("/api/admin/etatRendezVous/")
public class EtatRendezVousRestAdmin  extends AbstractController<EtatRendezVous, EtatRendezVousDto, EtatRendezVousHistory, EtatRendezVousCriteria, EtatRendezVousHistoryCriteria, EtatRendezVousAdminService, EtatRendezVousConverter> {



    @ApiOperation("upload one etatRendezVous")
    @RequestMapping(value = "upload", method = RequestMethod.POST, consumes = "multipart/form-data")
    public ResponseEntity<FileTempDto> uploadFileAndGetChecksum(@RequestBody MultipartFile file) throws Exception {
        return super.uploadFileAndGetChecksum(file);
    }
    @ApiOperation("upload multiple etatRendezVouss")
    @RequestMapping(value = "upload-multiple", method = RequestMethod.POST, consumes = "multipart/form-data")
    public ResponseEntity<List<FileTempDto>> uploadMultipleFileAndGetChecksum(@RequestBody MultipartFile[] files) throws Exception {
        return super.uploadMultipleFileAndGetChecksum(files);
    }

    @ApiOperation("Finds a list of all etatRendezVouss")
    @GetMapping("")
    public ResponseEntity<List<EtatRendezVousDto>> findAll() throws Exception {
        return super.findAll();
    }

    @ApiOperation("Finds an optimized list of all etatRendezVouss")
    @GetMapping("optimized")
    public ResponseEntity<List<EtatRendezVousDto>> findAllOptimized() throws Exception {
        return super.findAllOptimized();
    }

    @ApiOperation("Finds a etatRendezVous by id")
    @GetMapping("id/{id}")
    public ResponseEntity<EtatRendezVousDto> findById(@PathVariable Long id, String[] includes, String[] excludes) throws Exception {
        return super.findById(id, includes, excludes);
    }
    @ApiOperation("Saves the specified  etatRendezVous")
    @PostMapping("")
    public ResponseEntity<EtatRendezVousDto> save(@RequestBody EtatRendezVousDto dto) throws Exception {
        return super.save(dto);
    }

    @ApiOperation("Updates the specified  etatRendezVous")
    @PutMapping("")
    public ResponseEntity<EtatRendezVousDto> update(@RequestBody EtatRendezVousDto dto) throws Exception {
        return super.update(dto);
    }

    @ApiOperation("Delete list of etatRendezVous")
    @PostMapping("multiple")
    public ResponseEntity<List<EtatRendezVousDto>> delete(@RequestBody List<EtatRendezVousDto> listToDelete) throws Exception {
        return super.delete(listToDelete);
    }
    @ApiOperation("Delete the specified etatRendezVous")
    @DeleteMapping("")
    public ResponseEntity<EtatRendezVousDto> delete(@RequestBody EtatRendezVousDto dto) throws Exception {
            return super.delete(dto);
    }

    @ApiOperation("Delete the specified etatRendezVous")
    @DeleteMapping("id/{id}")
    public ResponseEntity<Long> deleteById(@PathVariable Long id) throws Exception {
        return super.deleteById(id);
    }
    @ApiOperation("Delete multiple etatRendezVouss by ids")
    @DeleteMapping("multiple/id")
    public ResponseEntity<List<Long>> deleteByIdIn(@RequestBody List<Long> ids) throws Exception {
            return super.deleteByIdIn(ids);
     }


    @ApiOperation("Finds etatRendezVouss by criteria")
    @PostMapping("find-by-criteria")
    public ResponseEntity<List<EtatRendezVousDto>> findByCriteria(@RequestBody EtatRendezVousCriteria criteria) throws Exception {
        return super.findByCriteria(criteria);
    }

    @ApiOperation("Finds paginated etatRendezVouss by criteria")
    @PostMapping("find-paginated-by-criteria")
    public ResponseEntity<PaginatedList> findPaginatedByCriteria(@RequestBody EtatRendezVousCriteria criteria) throws Exception {
        return super.findPaginatedByCriteria(criteria);
    }

    @ApiOperation("Exports etatRendezVouss by criteria")
    @PostMapping("export")
    public ResponseEntity<InputStreamResource> export(@RequestBody EtatRendezVousCriteria criteria) throws Exception {
        return super.export(criteria);
    }

    @ApiOperation("Gets etatRendezVous data size by criteria")
    @PostMapping("data-size-by-criteria")
    public ResponseEntity<Integer> getDataSize(@RequestBody EtatRendezVousCriteria criteria) throws Exception {
        return super.getDataSize(criteria);
    }

    @ApiOperation("Gets etatRendezVous history by id")
    @GetMapping("history/id/{id}")
    public ResponseEntity<AuditEntityDto> findHistoryById(@PathVariable("id") Long id) throws Exception {
        return super.findHistoryById(id);
    }

    @ApiOperation("Gets etatRendezVous paginated history by criteria")
    @PostMapping("history-paginated-by-criteria")
    public ResponseEntity<PaginatedList> findHistoryPaginatedByCriteria(@RequestBody EtatRendezVousHistoryCriteria criteria) throws Exception {
        return super.findHistoryPaginatedByCriteria(criteria);
    }

    @ApiOperation("Exports etatRendezVous history by criteria")
    @PostMapping("export-history")
    public ResponseEntity<InputStreamResource> exportHistory(@RequestBody EtatRendezVousHistoryCriteria criteria) throws Exception {
        return super.exportHistory(criteria);
    }

    @ApiOperation("Gets etatRendezVous history data size by criteria")
    @PostMapping("history-data-size")
    public ResponseEntity<Integer> getHistoryDataSize(@RequestBody EtatRendezVousHistoryCriteria criteria) throws Exception {
        return super.getHistoryDataSize(criteria);
    }
    public EtatRendezVousRestAdmin (EtatRendezVousAdminService service, EtatRendezVousConverter converter) {
        super(service, converter);
    }


}