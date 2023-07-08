import {Button} from 'primereact/button';
import {Column} from 'primereact/column';
import 'primereact/resources/themes/saga-blue/theme.css';
import 'primereact/resources/primereact.min.css';
import 'primeicons/primeicons.css';
import {DataTable} from 'primereact/datatable';
import {Dialog} from 'primereact/dialog';
import {FileUpload} from 'primereact/fileupload';
import {InputText} from 'primereact/inputtext';
import {Toast} from 'primereact/toast';
import {Toolbar} from 'primereact/toolbar';
import React, {useEffect, useRef, useState} from 'react';
import { Paginator } from 'primereact/paginator';
import {BaseCriteria} from '/pages/zynerator/criteria/BaseCriteria.model';
import {MessageService} from '/pages/controller/service/MessageService';
import {Card} from "primereact/card";
import {Calendar} from "primereact/calendar";
import {InputNumber} from "primereact/inputnumber";
import {Dropdown} from "primereact/dropdown";
import {AxiosResponse} from "axios";

import {PatientService} from '/pages/controller/service/Patient.service';
import {PatientDto}  from '/pages/controller/model/Patient.model';
import {PatientCriteria} from "/pages/controller/criteria/PatientCriteria.model";

import {GenderDto} from '/pages/controller/model/Gender.model';
import {GenderService} from '/pages/controller/service/Gender.service';
import {VilleDto} from '/pages/controller/model/Ville.model';
import {VilleService} from '/pages/controller/service/Ville.service';

import Edit from '/pages/module/admin/view/rdv/patient-admin/edit-admin/patient-edit-admin.component';
import Create from '/pages/module/admin/view/rdv/patient-admin/create-admin/patient-create-admin.component';
import View from '/pages/module/admin/view/rdv/patient-admin/view-admin/patient-view-admin.component';

const List = () => {

    const emptyItem = new PatientDto();
    const [items, setItems] = useState<PatientDto[]>([]);
    const [deleteItemDialog, setDeleteItemDialog] = useState(false);
    const [deleteItemsDialog, setDeleteItemsDialog] = useState(false);
    const [item, setItem] = useState<PatientDto>(emptyItem);
    const [selectedItems, setSelectedItems] = useState<PatientDto[]>([]);
    const [globalFilter, setGlobalFilter] = useState('');
    const [showCreateDialog, setShowCreateDialog] = useState<boolean>(false);
    const [showEditDialog, setShowEditDialog] = useState<boolean>(false);
    const [showViewDialog, setShowViewDialog] = useState<boolean>(false);
    const [selectedItem, setSelectedItem] = useState<PatientDto | null>(null);
    const [rows, setRows] = useState<number>(10);
    const [totalRecords, setTotalRecords] = useState(0);
    const [criteria, setCriteria] = useState(new PatientCriteria());
    const [first, setFirst] = useState(0);
    const toast = useRef<Toast>();
    const dt = useRef<DataTable<PatientDto[]>>();
    const [findByCriteriaShow, setFindByCriteriaShow] = useState(false);
    const [isSearchTriggered, setIsSearchTriggered] = useState(false);

    const [genders, setGenders] = useState<GenderDto[]>([]);
    type GenderResponse = AxiosResponse<GenderDto[]>;
    const [villes, setVilles] = useState<VilleDto[]>([]);
    type VilleResponse = AxiosResponse<VilleDto[]>;

    const showSearch = () => { setFindByCriteriaShow(!findByCriteriaShow); };

    const handleValidateClick = () => {setIsSearchTriggered(true);};

    const handleCancelClick = () => {
        setCriteria(new PatientCriteria());
        setIsSearchTriggered(true);
    };

    useEffect(() => {
        const fetchData = async () => {
            try {
                const [villesResponse ,gendersResponse ] = await Promise.all<VilleResponse,GenderResponse>([
                    VilleService.getList(),
                    GenderService.getList(),
                ]);
                setVilles(villesResponse.data);
                setGenders(gendersResponse.data);
            } catch (error) {
                console.error(error);
            }
        };
        if (isSearchTriggered) {
            fetchItems(criteria);
            setIsSearchTriggered(false);
        }
        fetchData();
        fetchItems(criteria);
    }, [isSearchTriggered]);

    const fetchItems = async (criteria) => {
        try {
            const response = await PatientService.findPaginatedByCriteria(criteria);
            const paginatedItems = response.data;
            setTotalRecords(paginatedItems.dataSize);
            setItems(paginatedItems.list);
        } catch (error) {
            console.log(error);
        }
    };

    const onPage = (event) => {
        const updatedCriteria = { ...criteria, page: event.page,maxResults: event.rows };
        setCriteria(updatedCriteria);
        setFirst(event.first);
        fetchItems(updatedCriteria);
    };

    const showCreateModal = (): void => {
        setShowCreateDialog(true);
    };

    const showEditModal = (item: PatientDto) => {
        setSelectedItem(item);
        setShowEditDialog(true);
    };

    const showViewModal = (item: PatientDto) => {
        setSelectedItem(item);
        setShowViewDialog(true);
    };

    const add = (item) => {
        setItems([...items, item]);
    };

    const update = (updatedItem: PatientDto) => {
        const updatedList = items.map((item) => {
            if (item.id === updatedItem.id) { return updatedItem; }
            return item;
        });
        setItems(updatedList);
    };

   const hideDeleteItemDialog = () => {
        setDeleteItemDialog(false);
   };

   const hideDeleteItemsDialog = () => {
        setDeleteItemsDialog(false);
   };

    const confirmDeleteItem = (item: PatientDto) => {
        setSelectedItem(item);
        setDeleteItemDialog(true);
    };

    const deleteItem = async () => {
        try{
            await PatientService.delete(selectedItem?.id);
            setDeleteItemDialog(false);
            setItem(emptyItem);
            let _items = items.filter((val) => val.id !== selectedItem?.id);
            setItems(_items);
            MessageService.showToast(toast, { severity: 'success', summary: 'Successful', detail: 'Patient Deleted', life: 3000 });
        } catch (error) {
            console.log(error);
        }
    };

    const exportCSV = () => {
        dt.current?.exportCSV();
    };

    const confirmDeleteSelected = () => {
        setDeleteItemsDialog(true);
    };

    const deleteSelectedItems = async () => {
        await PatientService.deleteList(selectedItems);
        let _items = items.filter((val) => !selectedItems.includes(val));
        setItems(_items);
        setDeleteItemsDialog(false);
        setSelectedItems(null);
        MessageService.showToast(toast, { severity: 'success', summary: 'Successful', detail: 'Patients Deleted', life: 3000 });
    };

   const leftToolbarTemplate = () => {
       return (
           <React.Fragment>
               <div className="my-2">
                   <Button label="New" icon="pi pi-plus" severity="success" className=" mr-2" onClick={ showCreateModal} />
                   <Button label="Delete" icon="pi pi-trash" severity="danger" className=" mr-2" onClick={confirmDeleteSelected} disabled={!selectedItems || !selectedItems.length} />
                   <Button label="Search" icon={`pi pi-${findByCriteriaShow ? 'angle-down' : 'angle-right'}`} className=" mr-2" severity="warning" onClick={showSearch} />
               </div>
           </React.Fragment>
       );
   };

   const rightToolbarTemplate = () => {
       return (
           <React.Fragment>
               <FileUpload mode="basic" accept="image/*" maxFileSize={1000000} chooseLabel="Import" className="mr-2 inline-block" />
               <Button label="Export" icon="pi pi-upload" severity="help" onClick={exportCSV} />
           </React.Fragment>
       );
   };

    const actionBodyTemplate = (rowData: PurchaseDto) => {
       return ( <>
           <Button icon="pi pi-pencil" rounded severity="success" className="mr-1" onClick={() => showEditModal(rowData)} />
           <Button icon="pi pi-trash" rounded  severity="danger" className="mr-1"  onClick={() => confirmDeleteItem(rowData)} />
           <Button icon="pi pi-eye" rounded severity="info" className="mr-1" onClick={() => showViewModal(rowData)} /> < />
       );
    };

    const header = (
        <div className="flex flex-column md:flex-row md:justify-content-between md:align-items-center">
        <h5 className="m-0">Manage Patients</h5>
        <span className="block mt-2 md:mt-0 p-input-icon-left"><i className="pi pi-search" />
        <InputText type="search" onInput={(e) => setGlobalFilter(e.currentTarget.value)} placeholder="Search..." /> </span>
        </div>
    );

    const deleteItemDialogFooter = ( <>
        <Button label="No" icon="pi pi-times" text onClick={hideDeleteItemDialog} />
        <Button label="Yes" icon="pi pi-check" text onClick={deleteItem} /> < />
    );

    const deleteItemsDialogFooter = ( <>
        <Button label="No" icon="pi pi-times" text onClick={hideDeleteItemsDialog} />
        <Button label="Yes" icon="pi pi-check" text onClick={deleteSelectedItems} /> < />
    );

return (
    <div className="grid crud-demo">
        <div className="col-12">
            <div className="card">
                <Toast ref={toast} />
                <Toolbar className="mb-4" left={leftToolbarTemplate} right={rightToolbarTemplate}></Toolbar>
                {findByCriteriaShow && (
                <Card>
                    <div className="search-container">
                        <div className="grid">
                                        <span className="p-float-label mr-3 align-search-items mt-4">
                                        <InputText id="1" value={criteria.ipp} onChange={(e) => setCriteria({ ...criteria, ipp: e.target.value })} />
                                        <label htmlFor="1">Ipp</label>
                                        </span>
                                        <span className="p-float-label mr-3 align-search-items mt-4">
                                        <InputText id="2" value={criteria.email} onChange={(e) => setCriteria({ ...criteria, email: e.target.value })} />
                                        <label htmlFor="2">Email</label>
                                        </span>
                                        <span className="p-float-label mr-3 align-search-items mt-4">
                                        <InputText id="3" value={criteria.cin} onChange={(e) => setCriteria({ ...criteria, cin: e.target.value })} />
                                        <label htmlFor="3">Cin</label>
                                        </span>
                                        <span className="p-float-label mr-3 align-search-items mt-4">
                                        <InputText id="4" value={criteria.nom} onChange={(e) => setCriteria({ ...criteria, nom: e.target.value })} />
                                        <label htmlFor="4">Nom</label>
                                        </span>
                                        <span className="p-float-label mr-3 align-search-items mt-4">
                                        <InputText id="5" value={criteria.prenom} onChange={(e) => setCriteria({ ...criteria, prenom: e.target.value })} />
                                        <label htmlFor="5">Prenom</label>
                                        </span>
                                        <span className="p-float-label mr-3 align-search-items mt-4">
                                        <InputNumber id="6-1" value={criteria.ageMin} onChange={(e) => setCriteria({ ...criteria, ageMin: e.value })} mode="decimal" />
                                        <label htmlFor="6-1">Age Min</label>
                                        </span>
                                        <span className="p-float-label mr-3 align-search-items mt-4">
                                        <InputNumber id="6-2" value={criteria.ageMax} onChange={(e) => setCriteria({ ...criteria, ageMax: e.value })} mode="decimal" />
                                        <label htmlFor="6-2">Age Max</label>
                                        </span>
                                        <span className="p-float-label mr-3 align-search-items mt-4">
                                        <Dropdown id="7" value={criteria.ville} options={villes} onChange={(e) => setCriteria({ ...criteria, ville: e.target.value })} optionLabel="libelle" filter showClear placeholder="Ville" />
                                        </span>
                                        <span className="p-float-label mr-3 align-search-items mt-4">
                                        <Dropdown id="8" value={criteria.gender} options={genders} onChange={(e) => setCriteria({ ...criteria, gender: e.target.value })} optionLabel="libelle" filter showClear placeholder="Gender" />
                                        </span>
                        </div>
                        <div style={{ marginTop : '1rem', display: 'flex', justifyContent: 'flex-end' }} >
                            <Button label="Validate" icon="pi pi-sort-amount-down" className="p-button-info mr-2" onClick={handleValidateClick} />
                            <Button label="Cancel" className="p-button-secondary mr-2"  icon="pi pi-times" onClick={handleCancelClick} />
                    </div>
                        </div>
                </Card>
                )}
                <DataTable ref={dt} value={items} selection={selectedItems} onSelectionChange={(e) => setSelectedItems(e.value as PatientDto[])} dataKey="id" className="datatable-responsive" globalFilter={globalFilter} header={header} responsiveLayout="scroll" >
                    <Column selectionMode="multiple" headerStyle={{ width: '4rem' }}> </Column>
                    
                    <Column field="ipp" header="Ipp" sortable headerStyle={{ minWidth: '15rem' }}></Column>
                    
                    
                    <Column field="email" header="Email" sortable headerStyle={{ minWidth: '15rem' }}></Column>
                    
                    
                    <Column field="cin" header="Cin" sortable headerStyle={{ minWidth: '15rem' }}></Column>
                    
                    
                    <Column field="nom" header="Nom" sortable headerStyle={{ minWidth: '15rem' }}></Column>
                    
                    
                    <Column field="prenom" header="Prenom" sortable headerStyle={{ minWidth: '15rem' }}></Column>
                    
                    
                    <Column field="age" header="Age" sortable headerStyle={{ minWidth: '15rem' }}></Column>
                    
                    
                    <Column field="ville.libelle" header="Ville" sortable headerStyle={{ minWidth: '15rem' }}></Column>
                    
                    
                    <Column field="gender.libelle" header="Gender" sortable headerStyle={{ minWidth: '15rem' }}></Column>
                    
                    <Column header="Actions" body={actionBodyTemplate} headerStyle={{minWidth: '10rem'}}></Column>
                </DataTable>
                <div className="p-d-flex p-ai-center p-jc-between">
                    <Paginator onPageChange={onPage} first={first} rows={rows} totalRecords={totalRecords} />
                </div>
                <Create visible={showCreateDialog} onClose={() => setShowCreateDialog(false)} add={add} showToast={toast} list={items} />
                <Edit  visible={showEditDialog} onClose={() =>  { setShowEditDialog(false); setSelectedItem(null); }} showToast={toast} selectedItem={selectedItem} update={update} />
                <View visible={showViewDialog} onClose={() =>  { setShowViewDialog(false); setSelectedItem(null); }} selectedItem={selectedItem} />
                <Dialog visible={deleteItemDialog} style={{width: '450px'}} header="Confirm" modal footer={deleteItemDialogFooter} onHide={hideDeleteItemDialog}>
                    <div className="flex align-items-center justify-content-center">
                    <i className="pi pi-exclamation-triangle mr-3" style={{fontSize: '2rem'}}/>
                    {item && (<span>Are you sure you want to delete patient <b>{item.id}</b>?</span>)}
                    </div>
                </Dialog>
                <Dialog visible={deleteItemsDialog} style={{width: '450px'}} header="Confirm" modal footer={deleteItemsDialogFooter} onHide={hideDeleteItemsDialog} >
                    <div className="flex align-items-center justify-content-center">
                    <i className="pi pi-exclamation-triangle mr-3" style={{fontSize: '2rem'}} />
                    {item && <span>Are you sure you want to delete the selected patients?</span>}
                    </div>
                </Dialog>
            </div>
        </div>
    </div>
);
};
export default List;

