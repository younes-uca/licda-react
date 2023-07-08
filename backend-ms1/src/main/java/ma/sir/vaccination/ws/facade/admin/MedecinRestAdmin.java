package  ma.sir.vaccination.ws.facade.admin;


import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import ma.sir.vaccination.bean.core.Medecin;
import ma.sir.vaccination.bean.history.MedecinHistory;
import ma.sir.vaccination.dao.criteria.core.MedecinCriteria;
import ma.sir.vaccination.dao.criteria.history.MedecinHistoryCriteria;
import ma.sir.vaccination.service.facade.admin.MedecinAdminService;
import ma.sir.vaccination.ws.converter.MedecinConverter;
import ma.sir.vaccination.ws.dto.MedecinDto;
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

@Api("Manages medecin services")
@RestController
@RequestMapping("/api/admin/medecin/")
public class MedecinRestAdmin  extends AbstractController<Medecin, MedecinDto, MedecinHistory, MedecinCriteria, MedecinHistoryCriteria, MedecinAdminService, MedecinConverter> {



    @ApiOperation("Exporte pdf")
    @PostMapping("exportPdf/")
    public HttpEntity<byte[]> createPdf(@RequestBody MedecinDto dto) throws Exception{
        return service.createPdf(dto);
    }
    @ApiOperation("upload one medecin")
    @RequestMapping(value = "upload", method = RequestMethod.POST, consumes = "multipart/form-data")
    public ResponseEntity<FileTempDto> uploadFileAndGetChecksum(@RequestBody MultipartFile file) throws Exception {
        return super.uploadFileAndGetChecksum(file);
    }
    @ApiOperation("upload multiple medecins")
    @RequestMapping(value = "upload-multiple", method = RequestMethod.POST, consumes = "multipart/form-data")
    public ResponseEntity<List<FileTempDto>> uploadMultipleFileAndGetChecksum(@RequestBody MultipartFile[] files) throws Exception {
        return super.uploadMultipleFileAndGetChecksum(files);
    }

    @ApiOperation("Finds a list of all medecins")
    @GetMapping("")
    public ResponseEntity<List<MedecinDto>> findAll() throws Exception {
        return super.findAll();
    }

    @ApiOperation("Finds an optimized list of all medecins")
    @GetMapping("optimized")
    public ResponseEntity<List<MedecinDto>> findAllOptimized() throws Exception {
        return super.findAllOptimized();
    }

    @ApiOperation("Finds a medecin by id")
    @GetMapping("id/{id}")
    public ResponseEntity<MedecinDto> findById(@PathVariable Long id, String[] includes, String[] excludes) throws Exception {
        return super.findById(id, includes, excludes);
    }
    @ApiOperation("Saves the specified  medecin")
    @PostMapping("")
    public ResponseEntity<MedecinDto> save(@RequestBody MedecinDto dto) throws Exception {
        return super.save(dto);
    }

    @ApiOperation("Updates the specified  medecin")
    @PutMapping("")
    public ResponseEntity<MedecinDto> update(@RequestBody MedecinDto dto) throws Exception {
        return super.update(dto);
    }

    @ApiOperation("Delete list of medecin")
    @PostMapping("multiple")
    public ResponseEntity<List<MedecinDto>> delete(@RequestBody List<MedecinDto> listToDelete) throws Exception {
        return super.delete(listToDelete);
    }
    @ApiOperation("Delete the specified medecin")
    @DeleteMapping("")
    public ResponseEntity<MedecinDto> delete(@RequestBody MedecinDto dto) throws Exception {
            return super.delete(dto);
    }

    @ApiOperation("Delete the specified medecin")
    @DeleteMapping("id/{id}")
    public ResponseEntity<Long> deleteById(@PathVariable Long id) throws Exception {
        return super.deleteById(id);
    }
    @ApiOperation("Delete multiple medecins by ids")
    @DeleteMapping("multiple/id")
    public ResponseEntity<List<Long>> deleteByIdIn(@RequestBody List<Long> ids) throws Exception {
            return super.deleteByIdIn(ids);
     }


    @ApiOperation("find by center id")
    @GetMapping("center/id/{id}")
    public List<Medecin> findByCenterId(@PathVariable Long id){
        return service.findByCenterId(id);
    }
    @ApiOperation("delete by center id")
    @DeleteMapping("center/id/{id}")
    public int deleteByCenterId(@PathVariable Long id){
        return service.deleteByCenterId(id);
    }
    @ApiOperation("Finds medecins by criteria")
    @PostMapping("find-by-criteria")
    public ResponseEntity<List<MedecinDto>> findByCriteria(@RequestBody MedecinCriteria criteria) throws Exception {
        return super.findByCriteria(criteria);
    }

    @ApiOperation("Finds paginated medecins by criteria")
    @PostMapping("find-paginated-by-criteria")
    public ResponseEntity<PaginatedList> findPaginatedByCriteria(@RequestBody MedecinCriteria criteria) throws Exception {
        return super.findPaginatedByCriteria(criteria);
    }

    @ApiOperation("Exports medecins by criteria")
    @PostMapping("export")
    public ResponseEntity<InputStreamResource> export(@RequestBody MedecinCriteria criteria) throws Exception {
        return super.export(criteria);
    }

    @ApiOperation("Gets medecin data size by criteria")
    @PostMapping("data-size-by-criteria")
    public ResponseEntity<Integer> getDataSize(@RequestBody MedecinCriteria criteria) throws Exception {
        return super.getDataSize(criteria);
    }

    @ApiOperation("Gets medecin history by id")
    @GetMapping("history/id/{id}")
    public ResponseEntity<AuditEntityDto> findHistoryById(@PathVariable("id") Long id) throws Exception {
        return super.findHistoryById(id);
    }

    @ApiOperation("Gets medecin paginated history by criteria")
    @PostMapping("history-paginated-by-criteria")
    public ResponseEntity<PaginatedList> findHistoryPaginatedByCriteria(@RequestBody MedecinHistoryCriteria criteria) throws Exception {
        return super.findHistoryPaginatedByCriteria(criteria);
    }

    @ApiOperation("Exports medecin history by criteria")
    @PostMapping("export-history")
    public ResponseEntity<InputStreamResource> exportHistory(@RequestBody MedecinHistoryCriteria criteria) throws Exception {
        return super.exportHistory(criteria);
    }

    @ApiOperation("Gets medecin history data size by criteria")
    @PostMapping("history-data-size")
    public ResponseEntity<Integer> getHistoryDataSize(@RequestBody MedecinHistoryCriteria criteria) throws Exception {
        return super.getHistoryDataSize(criteria);
    }
    public MedecinRestAdmin (MedecinAdminService service, MedecinConverter converter) {
        super(service, converter);
    }


}