package  ma.sir.vaccination.ws.facade.admin;


import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import ma.sir.vaccination.bean.core.Center;
import ma.sir.vaccination.bean.history.CenterHistory;
import ma.sir.vaccination.dao.criteria.core.CenterCriteria;
import ma.sir.vaccination.dao.criteria.history.CenterHistoryCriteria;
import ma.sir.vaccination.service.facade.admin.CenterAdminService;
import ma.sir.vaccination.ws.converter.CenterConverter;
import ma.sir.vaccination.ws.dto.CenterDto;
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

@Api("Manages center services")
@RestController
@RequestMapping("/api/admin/center/")
public class CenterRestAdmin  extends AbstractController<Center, CenterDto, CenterHistory, CenterCriteria, CenterHistoryCriteria, CenterAdminService, CenterConverter> {



    @ApiOperation("upload one center")
    @RequestMapping(value = "upload", method = RequestMethod.POST, consumes = "multipart/form-data")
    public ResponseEntity<FileTempDto> uploadFileAndGetChecksum(@RequestBody MultipartFile file) throws Exception {
        return super.uploadFileAndGetChecksum(file);
    }
    @ApiOperation("upload multiple centers")
    @RequestMapping(value = "upload-multiple", method = RequestMethod.POST, consumes = "multipart/form-data")
    public ResponseEntity<List<FileTempDto>> uploadMultipleFileAndGetChecksum(@RequestBody MultipartFile[] files) throws Exception {
        return super.uploadMultipleFileAndGetChecksum(files);
    }

    @ApiOperation("Finds a list of all centers")
    @GetMapping("")
    public ResponseEntity<List<CenterDto>> findAll() throws Exception {
        return super.findAll();
    }

    @ApiOperation("Finds an optimized list of all centers")
    @GetMapping("optimized")
    public ResponseEntity<List<CenterDto>> findAllOptimized() throws Exception {
        return super.findAllOptimized();
    }

    @ApiOperation("Finds a center by id")
    @GetMapping("id/{id}")
    public ResponseEntity<CenterDto> findById(@PathVariable Long id, String[] includes, String[] excludes) throws Exception {
        return super.findById(id, includes, excludes);
    }
    @ApiOperation("Saves the specified  center")
    @PostMapping("")
    public ResponseEntity<CenterDto> save(@RequestBody CenterDto dto) throws Exception {
        return super.save(dto);
    }

    @ApiOperation("Updates the specified  center")
    @PutMapping("")
    public ResponseEntity<CenterDto> update(@RequestBody CenterDto dto) throws Exception {
        return super.update(dto);
    }

    @ApiOperation("Delete list of center")
    @PostMapping("multiple")
    public ResponseEntity<List<CenterDto>> delete(@RequestBody List<CenterDto> listToDelete) throws Exception {
        return super.delete(listToDelete);
    }
    @ApiOperation("Delete the specified center")
    @DeleteMapping("")
    public ResponseEntity<CenterDto> delete(@RequestBody CenterDto dto) throws Exception {
            return super.delete(dto);
    }

    @ApiOperation("Delete the specified center")
    @DeleteMapping("id/{id}")
    public ResponseEntity<Long> deleteById(@PathVariable Long id) throws Exception {
        return super.deleteById(id);
    }
    @ApiOperation("Delete multiple centers by ids")
    @DeleteMapping("multiple/id")
    public ResponseEntity<List<Long>> deleteByIdIn(@RequestBody List<Long> ids) throws Exception {
            return super.deleteByIdIn(ids);
     }


    @ApiOperation("find by quartier id")
    @GetMapping("quartier/id/{id}")
    public List<Center> findByQuartierId(@PathVariable Long id){
        return service.findByQuartierId(id);
    }
    @ApiOperation("delete by quartier id")
    @DeleteMapping("quartier/id/{id}")
    public int deleteByQuartierId(@PathVariable Long id){
        return service.deleteByQuartierId(id);
    }
    @ApiOperation("Finds centers by criteria")
    @PostMapping("find-by-criteria")
    public ResponseEntity<List<CenterDto>> findByCriteria(@RequestBody CenterCriteria criteria) throws Exception {
        return super.findByCriteria(criteria);
    }

    @ApiOperation("Finds paginated centers by criteria")
    @PostMapping("find-paginated-by-criteria")
    public ResponseEntity<PaginatedList> findPaginatedByCriteria(@RequestBody CenterCriteria criteria) throws Exception {
        return super.findPaginatedByCriteria(criteria);
    }

    @ApiOperation("Exports centers by criteria")
    @PostMapping("export")
    public ResponseEntity<InputStreamResource> export(@RequestBody CenterCriteria criteria) throws Exception {
        return super.export(criteria);
    }

    @ApiOperation("Gets center data size by criteria")
    @PostMapping("data-size-by-criteria")
    public ResponseEntity<Integer> getDataSize(@RequestBody CenterCriteria criteria) throws Exception {
        return super.getDataSize(criteria);
    }

    @ApiOperation("Gets center history by id")
    @GetMapping("history/id/{id}")
    public ResponseEntity<AuditEntityDto> findHistoryById(@PathVariable("id") Long id) throws Exception {
        return super.findHistoryById(id);
    }

    @ApiOperation("Gets center paginated history by criteria")
    @PostMapping("history-paginated-by-criteria")
    public ResponseEntity<PaginatedList> findHistoryPaginatedByCriteria(@RequestBody CenterHistoryCriteria criteria) throws Exception {
        return super.findHistoryPaginatedByCriteria(criteria);
    }

    @ApiOperation("Exports center history by criteria")
    @PostMapping("export-history")
    public ResponseEntity<InputStreamResource> exportHistory(@RequestBody CenterHistoryCriteria criteria) throws Exception {
        return super.exportHistory(criteria);
    }

    @ApiOperation("Gets center history data size by criteria")
    @PostMapping("history-data-size")
    public ResponseEntity<Integer> getHistoryDataSize(@RequestBody CenterHistoryCriteria criteria) throws Exception {
        return super.getHistoryDataSize(criteria);
    }
    public CenterRestAdmin (CenterAdminService service, CenterConverter converter) {
        super(service, converter);
    }


}