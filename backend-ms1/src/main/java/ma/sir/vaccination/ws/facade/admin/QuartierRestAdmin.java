package  ma.sir.vaccination.ws.facade.admin;


import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import ma.sir.vaccination.bean.core.Quartier;
import ma.sir.vaccination.bean.history.QuartierHistory;
import ma.sir.vaccination.dao.criteria.core.QuartierCriteria;
import ma.sir.vaccination.dao.criteria.history.QuartierHistoryCriteria;
import ma.sir.vaccination.service.facade.admin.QuartierAdminService;
import ma.sir.vaccination.ws.converter.QuartierConverter;
import ma.sir.vaccination.ws.dto.QuartierDto;
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

@Api("Manages quartier services")
@RestController
@RequestMapping("/api/admin/quartier/")
public class QuartierRestAdmin  extends AbstractController<Quartier, QuartierDto, QuartierHistory, QuartierCriteria, QuartierHistoryCriteria, QuartierAdminService, QuartierConverter> {



    @ApiOperation("upload one quartier")
    @RequestMapping(value = "upload", method = RequestMethod.POST, consumes = "multipart/form-data")
    public ResponseEntity<FileTempDto> uploadFileAndGetChecksum(@RequestBody MultipartFile file) throws Exception {
        return super.uploadFileAndGetChecksum(file);
    }
    @ApiOperation("upload multiple quartiers")
    @RequestMapping(value = "upload-multiple", method = RequestMethod.POST, consumes = "multipart/form-data")
    public ResponseEntity<List<FileTempDto>> uploadMultipleFileAndGetChecksum(@RequestBody MultipartFile[] files) throws Exception {
        return super.uploadMultipleFileAndGetChecksum(files);
    }

    @ApiOperation("Finds a list of all quartiers")
    @GetMapping("")
    public ResponseEntity<List<QuartierDto>> findAll() throws Exception {
        return super.findAll();
    }

    @ApiOperation("Finds an optimized list of all quartiers")
    @GetMapping("optimized")
    public ResponseEntity<List<QuartierDto>> findAllOptimized() throws Exception {
        return super.findAllOptimized();
    }

    @ApiOperation("Finds a quartier by id")
    @GetMapping("id/{id}")
    public ResponseEntity<QuartierDto> findById(@PathVariable Long id, String[] includes, String[] excludes) throws Exception {
        return super.findById(id, includes, excludes);
    }
    @ApiOperation("Saves the specified  quartier")
    @PostMapping("")
    public ResponseEntity<QuartierDto> save(@RequestBody QuartierDto dto) throws Exception {
        return super.save(dto);
    }

    @ApiOperation("Updates the specified  quartier")
    @PutMapping("")
    public ResponseEntity<QuartierDto> update(@RequestBody QuartierDto dto) throws Exception {
        return super.update(dto);
    }

    @ApiOperation("Delete list of quartier")
    @PostMapping("multiple")
    public ResponseEntity<List<QuartierDto>> delete(@RequestBody List<QuartierDto> listToDelete) throws Exception {
        return super.delete(listToDelete);
    }
    @ApiOperation("Delete the specified quartier")
    @DeleteMapping("")
    public ResponseEntity<QuartierDto> delete(@RequestBody QuartierDto dto) throws Exception {
            return super.delete(dto);
    }

    @ApiOperation("Delete the specified quartier")
    @DeleteMapping("id/{id}")
    public ResponseEntity<Long> deleteById(@PathVariable Long id) throws Exception {
        return super.deleteById(id);
    }
    @ApiOperation("Delete multiple quartiers by ids")
    @DeleteMapping("multiple/id")
    public ResponseEntity<List<Long>> deleteByIdIn(@RequestBody List<Long> ids) throws Exception {
            return super.deleteByIdIn(ids);
     }


    @ApiOperation("find by ville id")
    @GetMapping("ville/id/{id}")
    public List<Quartier> findByVilleId(@PathVariable Long id){
        return service.findByVilleId(id);
    }
    @ApiOperation("delete by ville id")
    @DeleteMapping("ville/id/{id}")
    public int deleteByVilleId(@PathVariable Long id){
        return service.deleteByVilleId(id);
    }
    @ApiOperation("Finds quartiers by criteria")
    @PostMapping("find-by-criteria")
    public ResponseEntity<List<QuartierDto>> findByCriteria(@RequestBody QuartierCriteria criteria) throws Exception {
        return super.findByCriteria(criteria);
    }

    @ApiOperation("Finds paginated quartiers by criteria")
    @PostMapping("find-paginated-by-criteria")
    public ResponseEntity<PaginatedList> findPaginatedByCriteria(@RequestBody QuartierCriteria criteria) throws Exception {
        return super.findPaginatedByCriteria(criteria);
    }

    @ApiOperation("Exports quartiers by criteria")
    @PostMapping("export")
    public ResponseEntity<InputStreamResource> export(@RequestBody QuartierCriteria criteria) throws Exception {
        return super.export(criteria);
    }

    @ApiOperation("Gets quartier data size by criteria")
    @PostMapping("data-size-by-criteria")
    public ResponseEntity<Integer> getDataSize(@RequestBody QuartierCriteria criteria) throws Exception {
        return super.getDataSize(criteria);
    }

    @ApiOperation("Gets quartier history by id")
    @GetMapping("history/id/{id}")
    public ResponseEntity<AuditEntityDto> findHistoryById(@PathVariable("id") Long id) throws Exception {
        return super.findHistoryById(id);
    }

    @ApiOperation("Gets quartier paginated history by criteria")
    @PostMapping("history-paginated-by-criteria")
    public ResponseEntity<PaginatedList> findHistoryPaginatedByCriteria(@RequestBody QuartierHistoryCriteria criteria) throws Exception {
        return super.findHistoryPaginatedByCriteria(criteria);
    }

    @ApiOperation("Exports quartier history by criteria")
    @PostMapping("export-history")
    public ResponseEntity<InputStreamResource> exportHistory(@RequestBody QuartierHistoryCriteria criteria) throws Exception {
        return super.exportHistory(criteria);
    }

    @ApiOperation("Gets quartier history data size by criteria")
    @PostMapping("history-data-size")
    public ResponseEntity<Integer> getHistoryDataSize(@RequestBody QuartierHistoryCriteria criteria) throws Exception {
        return super.getHistoryDataSize(criteria);
    }
    public QuartierRestAdmin (QuartierAdminService service, QuartierConverter converter) {
        super(service, converter);
    }


}